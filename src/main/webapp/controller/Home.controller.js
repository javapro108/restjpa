sap.ui.define([ 'jquery.sap.global', 'sap/ui/core/Fragment',
		'sap/ui/core/mvc/Controller', 'sap/ui/model/json/JSONModel',
		'sap/m/Popover', 'sap/m/Button' ], 
	function (jQuery, Fragment, Controller, JSONModel, Popover, Button) {
	"use strict";
	return Controller.extend("web.app.controller.Home", {

		model : new sap.ui.model.json.JSONModel(),
		data : {
			navigation : [ {
				title : 'Overview',
				icon : 'sap-icon://electrocardiogram',
				key : 'Oberview',				
				items : [ {
					title : 'Reports',
					key : 'Reports'
				}, {
					title : 'Expenses',
					key : 'Expenses'
				} ]
			}, {
				title : 'Company',
				icon : 'sap-icon://manager',
				key : 'Company',
				items : [ {
					title : 'Search Company',
					key : 'SearchCompany'
				}, {
					title : 'Create Company',
					key : 'CreateCompany'
				} ]
			}, {
				title : 'Contacts',
				icon : 'sap-icon://employee',
				key : 'Contacts',
				items : [ {
					title : 'Search Contacts',
					key : 'SearchContacts'
				}, {
					title : 'Create Contacts',
					key : 'CreateContacts'
				} ]
			}, {
				title : 'Projects',
				icon : 'sap-icon://capital-projects',
				key : 'Projects',
				items : [ {
					title : 'Search Project',
					key : 'SearchProject'
				}, {
					title : 'Create Project',
					key : 'CreateProject'
				} ]
			}, {
				title : 'Job',
				icon : 'sap-icon://wrench',
				key : 'Job',
				items : [ {
					title : 'Search Job',
					key : 'SearchJob'
				}, {
					title : 'Create Job',
					key : 'CreateJob'
				} ]
			}],
			fixedNavigation : [ {
				title : 'Security',
				icon : 'sap-icon://shield'
			}, {
				title : 'Admin',
				icon : 'sap-icon://key-user-settings'
			}]
		},

		onInit : function() {
			this.model.setData(this.data);
			this.getView().setModel(this.model);

			this._setToggleButtonTooltip(!sap.ui.Device.system.desktop);
		},

		onItemSelect : function(oEvent) {
			var item = oEvent.getParameter('item');
			var viewId = this.getView().getId();
			sap.ui.getCore().byId(viewId + "--pageContainer").to(
					viewId + "--" + item.getKey());
		},

		onSideNavButtonPress : function() {
			var toolPage = this.getView().byId('homePage');
			var sideExpanded = toolPage.getSideExpanded();

			this._setToggleButtonTooltip(sideExpanded);

			toolPage.setSideExpanded(!toolPage.getSideExpanded());
		},

		_setToggleButtonTooltip : function(bLarge) {
			var toggleButton = this.getView()
					.byId('sideNavigationToggleButton');
			if (bLarge) {
				toggleButton.setTooltip('Large Size Navigation');
			} else {
				toggleButton.setTooltip('Small Size Navigation');
			}
		}

	});
});
