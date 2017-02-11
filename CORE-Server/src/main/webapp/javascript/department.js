
$(function() {
		jQuery.noConflict();
	});

function editRow(rowid){
	var recentRow =  jQuery("#"+rowid);

	jQuery("tr").css('background-color', '#FFFFFF');
	jQuery(".delete").attr('checked',false);

	recentRow.css('background-color', '#FFFF99');
	recentRow.find('input').attr('checked',true);

	recentRow.find("td").each(
	    function () {
		    if(jQuery(this).attr("class") != ""){
			jQuery("#"+jQuery(this).attr("class")).val(jQuery(this).text());
		    }	
	    }
	); 
}

function checkRow(rowid,check){
	var recentRow =  jQuery("#"+rowid);
	if(check){
		recentRow.css('background-color', '#FFFF99');
	} else {
		recentRow.css('background-color', '#FFFFFF');
	}
}

function clearForm(formId){
	var form =  jQuery("#" + formId);
	form.validate().resetForm();
	form.find("input").each(
		function () {
			jQuery(this).val("");
		}
	);

	jQuery("tr").css('background-color', '#FFFFFF');
	jQuery(".delete").attr('checked',false);

}

function searchForm(formId,pageSize,page){
	var form =  jQuery("#" + formId);
	var dataString = form.serialize()+"&pageSize=" + pageSize + "&page=" + page;

	jQuery.ajax({
			type: "POST",
			url: "departmentSearch.action",
			data: dataString,
			success: function(response) {
				jQuery("#departmentList").html(response);
			}
	});
}

function deleteObjs(formId){
	var idList = "";
	jQuery(".delete:checked'").each(
		function () {
			idList += jQuery(this).val() +",";
		}
	);
	idList= idList.slice(0,idList.length-1); 

	if(idList== ""){
		return false;
	}

	var dataString = "idList=" + idList;

	ajaxExe(dataString, 'delete');

}

function saveForm(formId){
	
	var form =  jQuery("#" + formId);
	
	if(!form.validate().form()) {
		return false;
	}
	
	var dataString = form.serialize();

	if( jQuery('#id').val() == "" ||  jQuery('#id').val() == "0"){
		ajaxExe(dataString,'insert');
	} else {
		ajaxExe(dataString,'update');
	}

	
}

function ajaxExe(dataString,flag){
	if(flag == "insert"){
	
		jQuery.ajax({
				type: "POST",
				url: "departmentInsert.action",
				data: dataString,
				success: function(response) {
					jQuery('#id').val('');
					jQuery("#departmentList").html(response);
				}
		});
	} else if(flag == "update"){
		jQuery.ajax({
				type: "POST",
				url: "departmentUpdate.action",
				data: dataString,
				success: function(response) {
					jQuery('#id').val('');
					jQuery("#departmentList").html(response);
				}
		});
	} else if(flag == "delete"){
		jQuery.ajax({
			type: "POST",
			url: "departmentDelete.action",
			data: dataString,
			success: function(response) {
				jQuery("#departmentList").html(response);
			}
		});
	}
}
