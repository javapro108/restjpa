sap.ui.define([ 'jquery.sap.global', "sap/ui/core/mvc/Controller", "sap/m/MessageToast" ], function(jQuery, Controller, MessageToast) {
	"use strict";
	return Controller.extend("web.app.controller.Login", {

		model : new sap.ui.model.json.JSONModel(),
		oData : {
			username : "username"
		},			
			
		onBeforeRendering : function(oEvent) {
		},

		onInit : function() {
			this.model.setData(this.oData);
			this.getView().setModel(this.model);
			this.view = this.getView();
		},

		onLogin : function() {
			debugger;

			var key = window.btoa(this.getView().byId('username').getValue() + ':' + this.getView().byId('password').getValue());					
			var loginObject = {
					uNamePass: key
			}
			this.callAJAX("api/login", "POST", loginObject, this);
						
		},
		
		callAJAX: function(url, method, data, context, sucess, error){
			jQuery.ajax({
				url:  url,
				type: method,
				data: JSON.stringify(data),
				dataType:    "json",
		        contentType: "application/json",
		        context: context,
		        success: success || context.onAJAXSuccess,
		        error: error || context.onAJAXError,
		        beforeSend: function(xhr){
				   	xhr.setRequestHeader("Authorization", window.localStorage.getItem("Auth-token"))
				},		        
			});			
		},

		onAJAXSuccess: function(data){
			debugger;
			this.getView().setBusy(false);
			window.localStorage.setItem("Auth-token", data.token);
			console.log("Response " + JSON.stringify(data));
			if ( data.token != "" && data.token != undefined ) {
				this.getView().byId("username").setValueState(sap.ui.core.ValueState.None);
				this.getView().byId("password").setValueState(sap.ui.core.ValueState.None);				
				sap.ui.core.UIComponent.getRouterFor(this.getView()).navTo("home");
			} else {
				this.getView().byId("username").setValueState(sap.ui.core.ValueState.Error);
				this.getView().byId("password").setValueState(sap.ui.core.ValueState.Error);
				MessageToast.show("Invalid Usernme OR Password", { duration: 5000, width: "40em" });									
			}
		},

		onAJAXError: function(data){
			debugger;
			console.log("AJAX error:" + JSON.stringify(data));
		}

	});
});