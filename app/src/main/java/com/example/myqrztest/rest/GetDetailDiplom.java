package com.example.myqrztest.rest;

import com.example.myqrztest.api.GitApi;
import com.example.myqrztest.model.DiplomDetailModel;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

/**
 * Created by dmitriy on 26.06.15.
 */
public class GetDetailDiplom {
    public static class Request extends RetrofitSpiceRequest<DiplomDetailModel,GitApi>{
        private long mId;
        public Request(long id) {
            super(DiplomDetailModel.class, GitApi.class);
            mId = id;
        }

        public long getmId() {
            return mId;
        }

        @Override
        public DiplomDetailModel loadDataFromNetwork() throws Exception {

            return getService().getDiplomDetail(mId);
        }
    }
}
