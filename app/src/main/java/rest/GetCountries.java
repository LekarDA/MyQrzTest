package rest;

import com.google.gson.annotations.SerializedName;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import api.GitApi;
import model.CountryModel;

/**
 * Created by dmitriy on 19.06.15.
 */
public class GetCountries {

    public static class Request extends RetrofitSpiceRequest<CountryModel.List,GitApi>{
        public Request(){
                  super(CountryModel.List.class,GitApi.class);
              }

        @Override
        public CountryModel.List loadDataFromNetwork() throws Exception {
            Response.Body response = getService().getCountries();
             return response.data;
        }
    }

    public static class Response {

        public static class Body {

            @SerializedName("status")
            private  String status;

            @SerializedName("data")
            private CountryModel.List data;
        }
    }
}
