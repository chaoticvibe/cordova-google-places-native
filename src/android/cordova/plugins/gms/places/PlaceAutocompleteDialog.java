package cordova.plugins.gms.places;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.compat.Place;
import com.google.android.libraries.places.compat.ui.PlaceAutocomplete;



public class PlaceAutocompleteDialog extends CordovaPlugin {

	public static final String ACTION_SHOW = "show";

	protected int AUTOCOMPLETE_REQUEST_CODE = 1;

	protected CallbackContext callbackContext = null;
	protected PlaceAutocomplete.IntentBuilder intentBuilder = null;

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
	}

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
		this.callbackContext = callbackContext;
		if (action.equals(this.ACTION_SHOW)) {
			this.show();
		} else {
			return false;
		}
		return true;
	}

	protected void show() {
		try {
			this.intentBuilder = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY);
			this.cordova.startActivityForResult((CordovaPlugin) this,
					this.intentBuilder.build(this.cordova.getActivity()), this.AUTOCOMPLETE_REQUEST_CODE);
		} catch (Exception exception) {
			this.callbackContext.error(exception.toString());
		}
	}

	protected JSONObject encodePlace(Place place) throws JSONException {
		JSONObject encodedPlace = new JSONObject();
		encodedPlace.put("name", place.getName());
		JSONObject encodedCoordinates = new JSONObject();
		encodedCoordinates.put("latitude", place.getLatLng().latitude);
		encodedCoordinates.put("longitude", place.getLatLng().longitude);
		encodedPlace.put("coordinates", encodedCoordinates);
		return encodedPlace;
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (this.callbackContext == null) {
			return;
		}
		if (requestCode != this.AUTOCOMPLETE_REQUEST_CODE) {
			return;
		}
		if (resultCode == Activity.RESULT_CANCELED) {
			this.callbackContext.error("Canceled.");
			return;
		}
		if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
			Status status = PlaceAutocomplete.getStatus(this.cordova.getActivity(), data);
			this.callbackContext.error(status.getStatusMessage());
			return;
		}
		try {
			Place place = PlaceAutocomplete.getPlace(this.cordova.getActivity(), data);
			if (place == null) {
				this.callbackContext.success();
				return;
			}
			JSONObject placeAsJSON = this.encodePlace(place);
			this.callbackContext.success(placeAsJSON);
		} catch (Exception exception) {
			this.callbackContext.error(exception.toString());
		}
	}

	public void onRestoreStateForActivityResult(Bundle state, CallbackContext callbackContext) {
		this.callbackContext = callbackContext;
	}

}
