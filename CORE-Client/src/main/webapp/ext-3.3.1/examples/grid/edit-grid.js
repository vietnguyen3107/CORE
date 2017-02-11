/*!
 * Ext JS Library 3.3.1
 * Copyright(c) 2006-2010 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

 
var grid;
var oldRowIdx = -1;
Ext.onReady(function(){

    /**
     * Handler specified for the 'Available' column renderer
     * @param {Object} value
     */
    function formatDate(value){
        return value ? value.dateFormat('d/m/Y') : '';
    }

	// create reusable renderer
	Ext.util.Format.comboRenderer = function(combo){
		return function(value){
			var record = combo.findRecord(combo.valueField, value);
			return record ? record.get(combo.displayField) : combo.valueNotFoundText;
		}
	}

	// create the combo instance
	var combo = new Ext.form.ComboBox({
		typeAhead: true,
		editable : false,
		triggerAction: 'all',
		lazyRender:true,
		mode: 'local',
		store: new Ext.data.ArrayStore({
			id: 0,
			fields: [
				'id',
				'name'
			],
			data: [[1, 'item1'], [2, 'item2'], [3, 'item3'], [4, 'item4'], [5, 'item5']]
		}),
		valueField: 'id',
		displayField: 'name'
	});

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
            editor: combo, // specify reference to combo instance
			renderer: Ext.util.Format.comboRenderer(combo) // pass combo instance to reusable renderer
        }, {
            header: 'Price',
            dataIndex: 'price',
            width: 70,
            align: 'right',
            //renderer: 'usMoney',
            editor: new fm.NumberField({
                allowBlank: false,
                allowNegative: false,
                //maxValue: 100000
            })
        }, {

          //xtype: 'checkcolumn',
            header: 'Indoor?',
            dataIndex: 'indoor',
            width: 55,

			editor:new fm.Checkbox({
				hideLabels:true,
				listeners: {
					specialkey: function(field, e){
						// e.HOME, e.END, e.PAGE_UP, e.PAGE_DOWN,
						// e.TAB, e.ESC, arrow keys: e.LEFT, e.RIGHT, e.UP, e.DOWN
						if (e.getKey() == e.ENTER) {
							field.setValue(!field.getValue());
							return false;
						} 					
					}
				}
			})
        }, {
            header: 'Available',
            dataIndex: 'availDate',
            width: 95,
            renderer: formatDate,
            editor: new fm.DateField({
                format: 'd/m/y',
/*                minValue: '01/01/06',
                disabledDays: [0, 6],
                disabledDaysText: 'Plants are not available on the weekends'
*/
				listeners: {
					specialkey: function(field, e){
						// e.HOME, e.END, e.PAGE_UP, e.PAGE_DOWN,
						// e.TAB, e.ESC, arrow keys: e.LEFT, e.RIGHT, e.UP, e.DOWN
						if (e.getKey() == e.TAB) {
							if(oldRowIdx == grid.store.getCount()-1){
								// Get the Record
								var record =  grid.store.getAt(oldRowIdx); 
								if(record && record.dirty && validateRecord(record)){
									addNewRecord(1);
									return false;
								}
							}
						}
					}
				}
            })
        },{
                xtype: 'actioncolumn',
				 header: 'Action',
                width: 50,
                items: [{
                    icon   : '../shared/icons/fam/accept.png',  // Use a URL in the icon config
                    tooltip: 'edit',
                    handler: function(grid, rowIndex, colIndex) {
                        //var rec = store.getAt(rowIndex);
                        //alert("Sell " + rec.get('company'));
						var record = store.getAt(rowIndex);
						insertOrUpdateRecord(record);
						
						//var idx = grid.store.indexOf(record);
						//var row = grid.getView().getRow(idx);
                    }
                },{
                    icon   : '../shared/icons/fam/delete.gif',  // Use a URL in the icon config
                    tooltip: 'delete',
                    handler: function(grid, rowIndex, colIndex) {
						// Get the Record
						var record =  grid.store.getAt(rowIndex); 
						if(record && record.data['id'] != 0){
							Ext.MessageBox.show({
								title:'Delete Confirm',
								msg: 'Bạn có muốn xoá item đã chọn?',
								buttons: Ext.MessageBox.YESNO,
								animEl: this.id,
								icon: Ext.MessageBox.QUESTION,
								fn : function(btn){
									if(btn == 'yes'){
										/*
										var dataString = "idList=" + idList;
										var url = formId + "Delete.action";
										var responseId = formId + "List";
										var tableId = formId + "Table";

										jQuery.ajax({
											type: "POST",
											url: url,
											data: dataString,
											success: function(response) {
												{
													jQuery("#" + responseId).html(response);

													gridTable(tableId);
													jcarousel(formId,1);
													Ext.example.msg('Done', 'Thành công!');
													mPanel.getActiveTab().scrollToMember(responseId);
												}	
											},
											error: function(){
												Ext.example.msg('Done', 'Có lỗi xảy ra!');
											}
										}); // ajax
										*/

										var record = store.getAt(rowIndex);
										deleteRecord(record);
									} //if btn yes
								}//function(btn)
							});//boxShow
						} else {
							Ext.example.msg('Error', "Record can't delete!");
						}//if-else	
                    }
                }]//items
            }
				
		]//column
    });

       // create the data store
    var store = new Ext.data.ArrayStore({
        fields: [
           {name: 'id',type :'int'},
			{name: 'common'},
           {name: 'botanical', type: 'float'},
           {name: 'light', type: 'float'},
           {name: 'price', type: 'float'},
           {name: 'availDate', type: 'date', dateFormat: 'd/m/Y'},
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
		trackMouseOver : true,
		stripeRows : true,
		loadMask: true,
        height: 500,
        autoExpandColumn: 'common', // column with this id will be expanded
        title: 'Edit Plants?',
        frame: true,
        clicksToEdit: 1,
/*        tbar: [{
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
		,		
		// paging bar on the bottom
        bbar: new Ext.PagingToolbar({
            pageSize: 25,
            store: store,
            displayInfo: true,
            displayMsg: 'Displaying topics {0} - {1} of {2}',
            emptyMsg: "No topics to display"
        
			items:[
                '-', {
                pressed: true,
                enableToggle:true,
                text: 'Show Preview',
                cls: 'x-btn-text-icon details',
                toggleHandler: function(btn, pressed){
                    var view = grid.getView();
                    view.showPreview = pressed;
                    view.refresh();
                }
            }]
		
        })
*/
    });

	grid.on({
		beforeedit:{
			fn: function(e){
				if(oldRowIdx != e.row){
					// Get the Record
					var record =  grid.store.getAt(oldRowIdx); 

					oldRowIdx = e.row;	

					if(record){
						if(record.dirty){
							//valideate value
							if(!validateRecord(record))
									return true; 
							//update
							if(record.data['id'] != 0)
								updateRecord(record);
							//add
							else 
								if(e.row != grid.store.getCount()-1){
									insertRecord(record);
									addNewRecord(1);
								}
								else{
									insertRecord(record);
									addNewRecord(0);
								}
						}
					}
					//return false;

/*					//Get field name
					var fieldName = grid.getColumnModel().getDataIndex(columnIndex); 
					var data = record.get(fieldName);
		 
					// get grid's <TD> HtmlElement at the specified coordinates
					var cell = grid.getView().getCell(rowIndex, columnIndex);
	 
					// get Ext.Element object
					var el = Ext.get(cell);
*/						
					
				}
			}
		}
	});

	addNewRecord(1);

});

function addNewRecord(num){
	//alert(num);
	for(i =0 ; i < num ; i++){
		// access the Record constructor through the grid's store
		var Plant = grid.getStore().recordType;
		var p = new Plant({
			id : 0,
			common: '',
			light: '',
			price: '',
			availDate: '',
			indoor: false
		});
		grid.store.insert(grid.store.getCount(), p);
	}
    grid.stopEditing();
	var count = grid.store.getCount();
    grid.startEditing(count-1, 1);
				
}

function validateRecord(record){
	//valideate value

		//validate common field
		if(!record.data['common'] || record.data['common'] == ''){
			//get index of record
			var rowIndex = grid.store.indexOf(record);

			// get grid's <TD> HtmlElement at the specified coordinates
			var cell = grid.getView().getCell(rowIndex, 1); 
			// get Ext.Element object
			var el = Ext.get(cell);

			Ext.fly(cell).highlight("ffff9c", {
			    attr: "background-color",
			    easing: 'easeOut',
			    duration: 5
 
			});
			return false; 
		}
		//validate date field
		//if(record.data['availDate'] )	alert(record.data['availDate'].dateFormat('d/m/Y'));
		

		//if ok,return true
		return true;

	
	//record doesn't change
	return true;
	//end validate
}

function insertRecord(record){
		record.set('id',grid.store.getCount());
		record.commit(); 
		Ext.example.msg('Done', 'Add record successful!');			
}

function updateRecord(record){
		record.commit(); 
		Ext.example.msg('Done', 'Update record ' + record.data['id'] + ' successful!');
}

function insertOrUpdateRecord(record){
	//valideate value
	if(!validateRecord(record))
			return false; 

	//update
	if(record.data['id'] != 0)
		updateRecord(record);
	//add
	else 
		insertRecord(record);
}

function deleteRecord(record){
	grid.store.remove(record);
	Ext.example.msg('Done', 'Delete record ' + record.data['id'] + ' successful!');
}

