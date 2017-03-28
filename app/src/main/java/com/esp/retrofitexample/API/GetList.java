package com.esp.retrofitexample.API;

import com.esp.retrofitexample.Bean.GetListBean;
import com.esp.retrofitexample.Utils.Configs;
import com.esp.retrofitexample.Utils.ResponseListener;
import com.esp.retrofitexample.Utils.Utils;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;

/**
 * Created by hardikjani on 6/29/16.
 */
public class GetList {

    public GetList(final ResponseListener responseListener) {


        GetRoutAPI apiMethod = Utils.getAdapter().create(GetRoutAPI.class);

        apiMethod.getBean( new Callback<GetListBean>() {
            @Override
            public void success(GetListBean getRoutBean, Response response) {
                System.out.println("=====URL======" + response.getUrl());
                if (response.getStatus() == 200) {
                    System.out.println("=========response=========" + response.getHeaders().toString());
                    responseListener.onResponce(Configs.TAG_USERLOGIN, Configs.RESULT_OK, getRoutBean);
                } else {
                    responseListener.onResponce(Configs.TAG_USERLOGIN, Configs.RESULT_FAIL, null);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println("=======" + error.toString());
                responseListener.onResponce(Configs.TAG_USERLOGIN, Configs.RESULT_FAIL, null);
            }
        });
    }

    public interface GetRoutAPI {
        //        @Headers(Configs.API_HEADER)
        @GET(Configs.API_GETLIST)
        void getBean(Callback<GetListBean> callback);

    }
}