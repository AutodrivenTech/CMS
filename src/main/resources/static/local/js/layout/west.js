$(function () {
	$.ajax({
		type : 'GET',
		url : '/system/menu/all',
		async : true,    //或false,是否异步
		data:{
			name:'yang',age:25
		},
		dataType : 'json',
		timeout : 5000,    //超时时间
		beforeSend : function(xhr){
		},
		success:function(data,textStatus,jqXHR){
			if (data == "" || data == null){
				return;
			}
			console.log(data.length);
			//makeMenuHTML(data);
		},
		error:function(xhr,textStatus){
		},
		complete:function(){
		}
	});
});

function makeMenuHTML(data){
	console.log(data);
	var baseHTML = '<li>' +
						'<a class="active-menu waves-effect waves-dark" href="/">' +
						'<i class="fa fa-dashboard"></i>' +
						'控制台' +
						'</a>' +
					'</li>';
	var html = baseHTML;
	for (var i = 0;i < data.length;i++){
		var firstItem = "";
		if (data[i].child == null || data[i].child.length == 0){
			firstItem += 	'<li>' +
								'<a href="javascript:volid(0);" class="waves-effect waves-dark">' +
									'<i class="fa fa-location-arrow"></i>' +
									data[i].chineseName +
								'</a>' +
							'</li>';
		} else {
			firstItem += 	'<li>' +
								'<a href="javascript:volid(0);" class="waves-effect waves-dark">' +
									'<i class="fa fa-location-arrow"></i>' +
									data[i].chineseName +
									'<span class="fa arrow"></span>' +
								'</a>';
			for (var j = 0;j < data[i].child.length;j++){
				var secondItem = "";
				secondItem +=	'<ul class="nav nav-second-level">' +
									'<li>' +
										'<a href="javascript:volid(0);">' +
											'<i class="fa fa-location-arrow"></i>' +
											data[i].child[j].chineseName +
										'</a>' +
									'</li>' +
								'</ul>';
				firstItem += secondItem;
			}
		
			firstItem += '</li>';
		}
		html += firstItem;
	}
	console.log(html);
	$("#main-menu").html(html);
}