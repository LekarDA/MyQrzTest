package rest;

import com.google.gson.annotations.SerializedName;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import api.GitApi;
import model.DiplomModel;

/**
 * Created by dmitriy on 22.06.15.
 */
public class GetDiplomsByRegions {
    public static class Request extends RetrofitSpiceRequest<DiplomModel.List, GitApi>{
        private long mCid;
        private long mRid;
        public Request(long cid,long rid){
            super(DiplomModel.List.class,GitApi.class);
            mCid = cid;
            mRid = rid;
        }

        @Override
        public DiplomModel.List loadDataFromNetwork() throws Exception {
            Response.Body response = getService().getDiplomByRegions(mCid, mRid);
            return response.awards;
        }
    }
    public class Response{
        public class Body{
            @SerializedName("STATUS")
            private String status;
            @SerializedName("awards")
            private DiplomModel.List awards;

            public class Pager{
                @SerializedName("pagevar")
                private String pagevar;
                @SerializedName("current")
                private int current;

            }
        }
    }
}
