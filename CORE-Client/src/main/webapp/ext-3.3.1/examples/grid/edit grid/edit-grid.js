/*!
 * Ext JS Library 3.3.1
 * Copyright(c) 2006-2010 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

  // sample static data for the store
    var myData = [
        [1,'3m Co',71.72,0.02,0.03,'9/1 12:00am',false],
        [2,'Alcoa Inc',29.01,0.42,1.47,'9/1 12:00am',false],
        [3,'Altria Group Inc',83.81,0.28,0.34,'9/1 12:00am',true],
        [4,'American Express Company',52.55,0.01,0.02,'9/1 12:00am',true],
        [5,'American International Group, Inc.',64.13,0.31,0.49,'9/1 12:00am',false],
        [6,'AT&T Inc.',31.61,-0.48,-1.54,'9/1 12:00am',false],
        [7,'Boeing Co.',75.43,0.53,0.71,'9/1 12:00am',false],
        [8,'Caterpillar Inc.',67.27,0.92,1.39,'9/1 12:00am',false],
        [9,'Citigroup, Inc.',49.37,0.02,0.04,'9/1 12:00am',false],
        [10,'E.I. du Pont de Nemours and Company',40.48,0.51,1.28,'9/1 12:00am',false],
        [11,'Exxon Mobil Corp',68.1,-0.43,-0.64,'9/1 12:00am',false],
        [12,'General Electric Company',34.14,-0.08,-0.23,'9/1 12:00am',false],
        [13,'General Motors Corporation',30.27,1.09,3.74,'9/1 12:00am',false],
        [14,'Hewlett-Packard Co.',36.53,-0.03,-0.08,'9/1 12:00am',false],
        [15,'Honeywell Intl Inc',38.77,0.05,0.13,'9/1 12:00am',false],
        [16,'Intel Corporation',19.88,0.31,1.58,'9/1 12:00am',false],
        [17,'International Business Machines',81.41,0.44,0.54,'9/1 12:00am',false],
        [18,'Johnson & Johnson',64.72,0.06,0.09,'9/1 12:00am',false],
        [19,'JP Morgan & Chase & Co',45.73,0.07,0.15,'9/1 12:00am',false],
        [20,'McDonald\'s Corporation',36.76,0.86,2.40,'9/1 12:00am',false],
        [21,'Merck & Co., Inc.',40.96,0.41,1.01,'9/1 12:00am',false],
        [22,'Microsoft Corporation',25.84,0.14,0.54,'9/1 12:00am',false],
        [23,'Pfizer Inc',27.96,0.4,1.45,'9/1 12:00am',false]
    ];
var grid;
Ext.onReady(function(){

    /**
     * Handler specified for the 'Available' column renderer
     * @param {Object} value
     */
    function formatDate(value){
        return value ? value.dateFormat('M d, Y') : '';
    }

    // shorthand alias
    var fm = Ext.form;

    // the column model has information about grid columns
    // dataIndex maps the column to the specific data field in
    // the data store (created below)
    var cm = new Ext.grid.ColumnModel({
        // specify any defaults for each column
        defaults: {
            sortable: true // columns are not sortable by default           
        },
        columns: [
			{
            id: 'id',
            header: 'Id',
            dataIndex: 'id',
            width: 20
        }, {
            id: 'common',
            header: 'Common Name',
            dataIndex: 'common',
            width: 220,
            // use shorthand alias defined above
            editor: new fm.TextField({
                allowBlank: false
            })
        }, {
            header: 'Light',
            dataIndex: 'light',
            width: 130,
            editor: new fm.ComboBox({
                typeAhead: true,
                triggerAction: 'all',
                // transform the data already specified in html
                transform: 'light',
                lazyRender: true
            })
        }, {
            header: 'Price',
            dataIndex: 'price',
            width: 70,
            align: 'right',
            renderer: 'usMoney',
            editor: new fm.NumberField({
                allowBlank: false,
                allowNegative: false,
                maxValue: 100000
            })
        }, {
            header: 'Available',
            dataIndex: 'availDate',
            width: 95,
            renderer: formatDate,
            editor: new fm.DateField({
                format: 'm/d/y',
                minValue: '01/01/06',
                disabledDays: [0, 6],
                disabledDaysText: 'Plants are not available on the weekends'
            })
        }, {
            xtype: 'checkcolumn',
            header: 'Indoor?',
            dataIndex: 'indoor',
            width: 55
        }, {

            header: "Button",
			dataIndex: 'button',
			width: 55,
			renderer: renderBtn
        }]
    });

       // create the data store
    var store = new Ext.data.ArrayStore({
        fields: [
           {name: 'id',type :'int'},
			{name: 'common'},
           {name: 'botanical', type: 'float'},
           {name: 'light', type: 'float'},
           {name: 'price', type: 'float'},
           {name: 'availDate', type: 'date', dateFormat: 'n/j h:ia'},
		   {name: 'indoor', type: 'bool'}
        ]
    });

    // manually load local data
    store.loadData(myData);

    // create the editor grid
    grid = new Ext.grid.EditorGridPanel({
        store: store,
        cm: cm,
        renderTo: 'editor-grid',
        width: 600,
        height: 300,
        autoExpandColumn: 'common', // column with this id will be expanded
        title: 'Edit Plants?',
        frame: true,
        clicksToEdit: 1,
        tbar: [{
            text: 'Add Plant',
            handler : function(){
                // access the Record constructor through the grid's store
                var Plant = grid.getStore().recordType;
                var p = new Plant({
					id : 0,
                    common: 'New Plant 1',
                    light: 'Mostly Shade',
                    price: 0,
                    availDate: (new Date()).clearTime(),
                    indoor: false
                });
                grid.stopEditing();
                store.insert(0, p);
                grid.startEditing(0, 1);
            }
        }]

    });

});
function renderBtn(val, p, record) {  
        var contentId = Ext.id();
        createGridButton.defer(1, this, [val, contentId, record]);
        return('<div id="' + contentId + '"></div>');
    }
function createGridButton(value, contentid, record) {
        new Ext.Button({text: 'save', handler : function(btn, e) {
				//alert("record data="+record.data['id']);
				Ext.example.msg('Done', 'Update record ' + record.data['id'] + ' successful!');
				var idx = grid.store.indexOf(record);
				var row = grid.getView().getRow(idx);
				record.commit() ;
				
			}
		}).render(document.body, contentid);
    }