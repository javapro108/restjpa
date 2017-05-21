sap.ui.define([ 'jquery.sap.global', "sap/ui/core/mvc/Controller" ], 
	function(jQuery, Controller) {
	"use strict";
	return Controller.extend("web.app.controller.Base", {


		onBeforeRendering : function(oEvent) {
		},

		onInit : function() {
			this.model.setData(this.oData);
			this.getView().setModel(this.model);
		},

		onLogin : function() {
			debugger;

			var key = window.btoa(this.getView().byId('username').getValue() + ':' + this.getView().byId('password').getValue());					
			var loginObject = {
					uNamePass: key
			}
			
			jQuery.ajax({
				url:  "api/login",
				type: "POST",
				data: JSON.stringify(loginObject),
				dataType:    "json",
		        contentType: "application/json",
		        beforeSend: function(xhr){
		        	xhr.setRequestHeader("Authorization", window.localStorage.getItem("Auth-token"))
		        }
			}).done(function(data){
				debugger;
				window.localStorage.setItem("Auth-token", data.token);
				console.log("Response " + JSON.stringify(data));
			});
			sap.ui.core.UIComponent.getRouterFor(this).navTo("home");
		}

	});
});