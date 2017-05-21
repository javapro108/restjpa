sap.ui.define(["sap/ui/core/UIComponent",
			   "sap/ui/model/json/JSONModel"],function(UIComponent, JSONModel){
	"use strict";
	return UIComponent.extend("web.app.Component",{
		metadata: {
			manifest: "json"
		},
		init: function(){
			UIComponent.prototype.init.apply(this, arguments);
			this.getRouter().initialize();
			
	        /*sap.ui.getCore().attachValidationError(function (oEvent) {
	            oEvent.getParameter("element").setValueState(ValueState.Error);
	        });

	        sap.ui.getCore().attachValidationSuccess(function (oEvent) {
	            oEvent.getParameter("element").setValueState(ValueState.None);
	        });*/			
		}
	});
});