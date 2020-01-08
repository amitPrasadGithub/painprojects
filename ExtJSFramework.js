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