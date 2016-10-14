package com.tulingchain.service.bill;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface BillNoderService {
	public abstract JSONArray queryMyBills(String pubk);
	public abstract JSONObject testApi(JSONObject bill);
	public abstract  JSONObject ensureDiscounting(String id);
}
