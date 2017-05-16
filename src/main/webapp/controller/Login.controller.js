sap.ui.define([
   "sap/ui/core/mvc/Controller"
], function (Controller) {
   "use strict";
   return Controller.extend("web.app.controller.Login", {
	   
	   onBeforeRendering: function(oEvent) {		   
		},
		
	   onLogin: function(){		   
		   sap.ui.core.UIComponent.getRouterFor(this).navTo("home");
	   }

   });
});