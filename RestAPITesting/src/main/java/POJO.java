import java.util.ArrayList;
import java.util.HashMap;

public class POJO {
	
	 HashMap  data;
	 HashMap support;
	 
	 POJO()
	 {
	 
	HashMap<String,String> data=new HashMap<String,String>();
	data.put("id", "2");
	data.put("name", "fuchsia rose");
	data.put("year", "2001");
	data.put("color", "#C74375");
	data.put("pantone_value", "17-2031");
	
	
	
	
	HashMap<String,String> support=new HashMap<String,String>();
	support.put("url", "https://reqres.in/#support-heading");
	support.put("text", "To keep ReqRes free, contributions towards server costs are appreciated!");
	
	
	 }

	public HashMap getData() {
		return data;
	}

	public void setData(HashMap data) {
		this.data = data;
	}

	public HashMap getSupport() {
		return support;
	}

	public void setSupport(HashMap support) {
		this.support = support;
	}

	@Override
	public String toString() {
		return "POJO [data=" + data + ", support=" + support + "]";
	}
	
	
	
	

}
