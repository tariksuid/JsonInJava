package jsonproj;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JsonReader {

	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		// TODO Auto-generated method stub
		JsonParser jsonParser = new JsonParser();

		JsonElement ele = jsonParser
				.parse(new FileReader("data.json"));

		Gson gson = new Gson();

		Root root = gson.fromJson(ele, Root.class);
		HashMap<String, String> rooms = root.assignment_results.get(0).shown_price;

		double maxPrice = 0.0;
		String maxRoom = "";

		String[] ar = new String[rooms.size()];
		rooms.keySet().toArray(ar);
		for (int i = 0; i < ar.length; i++) {
			double mx = Double.parseDouble(rooms.get(ar[i]));
			if (mx > maxPrice) {
				maxPrice = mx;
				maxRoom = ar[i];
			}
		}

		System.out.println("-------------MOST EXPENSIVE ROOM DETAILS -----------------");
		System.out.println(" ROOM NAME: " + maxRoom + " ROOM PRICE " + maxPrice);
		System.out.println(" NUMBER OF ALLOWED GUESTS = " + root.assignment_results.get(0).number_of_guests);

	}

}

class ExtData {
	public double scan_longitude;
	public double scan_latitude;
	public int scan_occupancy_from_scan;
	public Object scan_checkin_from_scan;
	public Object scan_checkout_from_scan;
	public String taxes;

	public ExtData(double scan_longitude, double scan_latitude, int scan_occupancy_from_scan,
			Object scan_checkin_from_scan, Object scan_checkout_from_scan, String taxes) {
		super();
		this.scan_longitude = scan_longitude;
		this.scan_latitude = scan_latitude;
		this.scan_occupancy_from_scan = scan_occupancy_from_scan;
		this.scan_checkin_from_scan = scan_checkin_from_scan;
		this.scan_checkout_from_scan = scan_checkout_from_scan;
		this.taxes = taxes;
	}

}

class AssignmentResult {
	public String deep_link;
	public String hotel_name;
	public String hotel_id;
	public ExtData ext_data;
	public String cancellation_policy;
	public int number_of_guests;
	public String breakfast;
	public HashMap<String, String> shown_price;
	public String currency;
	public HashMap<String, String> net_price;
	public String availability;
	public String ci_date;
	public String co_date;
	public int los;
	public String site_name;
	public String site_type;
	public String shown_currency;
	public String pos;
	public List<String> snapshot_url;

	public AssignmentResult(String deep_link, String hotel_name, String hotel_id, ExtData ext_data,
			String cancellation_policy, int number_of_guests, String breakfast, HashMap<String, String> shown_price,
			String currency, HashMap<String, String> net_price, String availability, String ci_date, String co_date,
			int los, String site_name, String site_type, String shown_currency, String pos, List<String> snapshot_url) {
		super();
		this.deep_link = deep_link;
		this.hotel_name = hotel_name;
		this.hotel_id = hotel_id;
		this.ext_data = ext_data;
		this.cancellation_policy = cancellation_policy;
		this.number_of_guests = number_of_guests;
		this.breakfast = breakfast;
		this.shown_price = shown_price;
		this.currency = currency;
		this.net_price = net_price;
		this.availability = availability;
		this.ci_date = ci_date;
		this.co_date = co_date;
		this.los = los;
		this.site_name = site_name;
		this.site_type = site_type;
		this.shown_currency = shown_currency;
		this.pos = pos;
		this.snapshot_url = snapshot_url;
	}

}

class AuxData {
	public String pid;
	public String input_uniqueness_key;
	public String pos;
	public int los;
	public int assignment_id;
	public String shop_currency_id;
	public String region;
	public String access_level;
	public String name;
	public String address;
	public String provider;
	public String customer_name;
	public String scan_level;
	public String scan_method;
	public int fn_hotel_id;
	public String scan_date;
	public String city;
	public String country;
	public String brand;
	public String chain;
	public String language_id;
	public String site_hotel_id;
	public String checkin;
	public String checkout;
	public String device;

	public AuxData(String pid, String input_uniqueness_key, String pos, int los, int assignment_id,
			String shop_currency_id, String region, String access_level, String name, String address, String provider,
			String customer_name, String scan_level, String scan_method, int fn_hotel_id, String scan_date, String city,
			String country, String brand, String chain, String language_id, String site_hotel_id, String checkin,
			String checkout, String device) {
		super();
		this.pid = pid;
		this.input_uniqueness_key = input_uniqueness_key;
		this.pos = pos;
		this.los = los;
		this.assignment_id = assignment_id;
		this.shop_currency_id = shop_currency_id;
		this.region = region;
		this.access_level = access_level;
		this.name = name;
		this.address = address;
		this.provider = provider;
		this.customer_name = customer_name;
		this.scan_level = scan_level;
		this.scan_method = scan_method;
		this.fn_hotel_id = fn_hotel_id;
		this.scan_date = scan_date;
		this.city = city;
		this.country = country;
		this.brand = brand;
		this.chain = chain;
		this.language_id = language_id;
		this.site_hotel_id = site_hotel_id;
		this.checkin = checkin;
		this.checkout = checkout;
		this.device = device;
	}

}

class Root {
	public List<AssignmentResult> assignment_results;
	public AuxData aux_data;

	public Root() {

	}

	public Root(List<AssignmentResult> assignment_results, AuxData aux_data) {
		super();
		this.assignment_results = assignment_results;
		this.aux_data = aux_data;
	}

	public List<AssignmentResult> getAssignment_results() {
		return assignment_results;
	}

	public void setAssignment_results(List<AssignmentResult> assignment_results) {
		this.assignment_results = assignment_results;
	}

	public AuxData getAux_data() {
		return aux_data;
	}

	public void setAux_data(AuxData aux_data) {
		this.aux_data = aux_data;
	}
}
