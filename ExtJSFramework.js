Ext.define (
	'CustomClasses.Student',
	{
		studentName:'unknown',
		id:0,

		constructor:	function(studentName, id) {
			this.studentName = studentName;
			this.id = id;
		},

		getStudentDetails:	function() {
			document.write(this.studentName);
			document.write(this.id);
		}, 
		
		statics: {
			getStudentAge:	function() {
				return 10;
			},
			address:'Delhi'
		}
	}
);

Ext.define(
	'CustomClasses.Parent', {
		className:'Parent',
		name:'parent',
		id:1,
		isParent:'yes', 

		// constructor:	function(id, name) {
			// this.id = id;
			// this.name = name;
		// },

		parentMethod:	function() {
			return "Parent Method";
		}
	}
);

Ext.define(
	'CustomClasses.Child', {
		extend:'CustomClasses.Parent',
		className:'Child',
		name:'child',
		id:2,
		
		mixins:	{
			parentMethod:'CustomClasses.Parent'
		}
					
		// constructor:	function(id, name) {
			// this.id = id;
			// this.name = name;
		// }
	}
);

Ext.define (
	'CustomClasses.ConfigDemo', {
		config: {
			configName:'unknown',
			configValue:'unknown'
		},
		constructor:	function(config) {
			this.initConfig(config);
		}
	}
);

Ext.define (
	'CustomClasses.CustomSettersAndGetters', {
		config:	{
			configName:'unknown',
			configValue:'unknown'
		},
		constructor:	function(config) {
			this.initConfig(config);
		},

		applyConfigName:	function(configName) {
			return Ext.String.capitalize(configName);
		},
		updateConfigName:	function(newValue, oldValue) {
			alert(newValue+"---"+oldValue);
		}
	}
);

Ext.define (
	'CustomClasses.CustomEvent', {
		config:	{
			configName:'unknown',
			configId:'unknown'
		},
		mixins:	{
			observable:'Ext.util.Observable'
		},
		constructor:	function(config) {
			this.mixins.observable.constructor.call(this, config);
		},
		updateConfigName:	function(newName, oldName) {
			this.fireEvent('configNameChanged', newName);
		}
	}
);
Ext.define(
	'CustomClasses.RadioButtonDemo', {
		createButtons:	function() {
			Ext.create(
				'Ext.Panel', {
					title:'RadionButtonDemo',
					width:300,
					bodypanel:10,
					renderTo:Ext.getBody(),
					
					items:	[
					{xtype:'label', text:'Button'},
						{
							fieldLabel:'Java', 
							id:'rb1',
							xtype:'radio', 
							name:'rbgroup', 
							check:false, 
							hiddenLabel:false,
							
							listeners:	{
								change:	function(field, newValue, oldValue) {
									if(newValue) {
										alert(field.fieldLabel);
									}
								}
							}
						},
						{
							fieldLabel:'C++', 
							id:'rb2', 
							xtype:'radio', 
							name:'rbgroup', 
							check:false, 
							hiddenLabel:false,
							
							listeners:	{
								change:	function(field, newValue, oldValue) {
									if(newValue) {
										alert(field.fieldLabel);
									}
								}
							}
						}
					], 
					
					bbar:	[

					]
				}
			);
		}
	}
);