sap.ui.define([
   "sap/ui/core/mvc/Controller"
], function (Controller) {
   "use strict";
   return Controller.extend("web.app.controller.Login", {
	   onLogin: function(){
		   console.log("Login Pressed");
		   window.alert("Login Pressed");
	   }
   });
});