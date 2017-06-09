sap.ui.define([ "sap/ui/core/mvc/Controller", "sap/ui/model/json/JSONModel",
		"jquery.sap.global" ], function(Controller, JSONModel, jQuery) {
	"use strict";
	return Controller.extend("web.app.controller.company.Company", {
		controlObject : {
<<<<<<< HEAD
			editable : true,
			title : "Create Company"
		},
		onInit : function() {
			var controlModel = new JSONModel();
			var oData = new JSONModel();

			controlModel.setData(this.controlObject);
			oData.setData({
				comName : ""
			});

			this.getView().setModel(oData);
			this.getView().setModel(controlModel, "control");
			sap.ui.getCore().getMessageManager().registerObject(this.getView(), true);
			
		},
		onSave : function() {
			debugger;
			var oModel = this.getView().getModel();
			var oData = oModel.getData();
			jQuery.ajax({
				url : "api/tblcompany(0)",
				type : "POST",
				data : JSON.stringify(oData),
				dataType : "json",
				contentType : "application/json",
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Authorization", window.localStorage.getItem("Auth-token"))
				}
			}).done(function(data) {
				debugger;
				console.log("Response " + JSON.stringify(data));
			});
		},
		onCancel : function() {

		},
=======
			editable : false,
			title : "Create Company"
		},
		onInit : function() {
			var controlModel = new JSONModel();
			var oData = new JSONModel();

			controlModel.setData(this.controlObject);
			oData.setData({
				comName : ""
			});

			this.getView().setModel(oData);
			this.getView().setModel(controlModel, "control");
			sap.ui.getCore().getMessageManager().registerObject(this.getView(), true);
			
		},
		onSave : function() {
			debugger;
			var thisView = this.getView(); 
			var oModel = this.getView().getModel();
			var oData = oModel.getData();
			
			var controlModel = this.getView().getModel("control");
			controlModel.setProperty("/editable", false);
			controlModel.refresh();
			thisView.setBusy();			
			
			jQuery.ajax({
				url : "api/company(0)",
				type : "POST",
				data : JSON.stringify(oData),
				dataType : "json",
				contentType : "application/json",
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Authorization", window.localStorage.getItem("Auth-token"))
				}
			}).done(this.onSaveSuccess);
			
		},
		onCancel : function() {

		},
		
		onSaveSuccess: function(data){
			var controlModel = this.getView().getModel("control");
		},
		
>>>>>>> branch 'master' of https://github.com/javapro108/restjpa.git
		onEditModeChange : function() {
			if (this.controlObject.editable == true) {
				editable = false;
			} else {
				editable = true;
			}
		}
	});
});