sap.ui.define([ 'jquery.sap.global', "sap/ui/core/mvc/Controller" ], function(jQuery, Controller) {
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
		},

		onLogin : function() {
			debugger;

			var key = window.btoa(this.getView().byId('username').getValue() + ':' + this.getView().byId('password').getValue());					
			
			console.log(key);
			console.log(window.atob(key));
			sap.ui.core.UIComponent.getRouterFor(this).navTo("home");
		}

	});
});