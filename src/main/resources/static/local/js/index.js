var languageType = 1;
$(function () {
	$("#languageChange").bootstrapSwitch({
		state : false,
		labelWidth : 1,
		onText : 'English',
		offText : '中文',
		onSwitchChange : function(event, state) {
			if (state){
				languageType = 2;
				$("#index_header_base_info").text("Base Info");
				$("#index_header_system_setting").text("System Setting");
				$("#index_header_exit").text("Exit");
			} else {
				languageType = 1;
				$("#index_header_base_info").text("基本信息");
				$("#index_header_system_setting").text("系统设置");
				$("#index_header_exit").text("安全退出");
			}
			selectAllMenuWithTreeByPermission();
		}
	});
	
	selectAllMenuWithTreeByPermission();
	
	$("#systemContentTabs").tabs({
        data: [{
            id: 'desktop',
            text: '控制台',
            url: "/desktop"
        }],
        loadAll: true
    });
});

function selectAllMenuWithTreeByPermission(){
	$.ajax({
		type : 'GET',
		url : '/system/menu/all/' + languageType,
		async : true,    //或false,是否异步
		data : {
		},
		dataType : 'json',
		timeout : 5000,    //超时时间
		beforeSend : function(xhr){
		},
		success:function(data,textStatus,jqXHR){
			if (data.code == '00000'){
				$('#systemMenuTree').treeview({
                    data: data.obj,         // 数据源
                    showCheckbox: false,   //是否显示复选框
                    highlightSelected: false,    //是否高亮选中
                    //nodeIcon: 'glyphicon glyphicon-user',    //节点上的图标
                    nodeIcon: 'glyphicon glyphicon-folder-close',
                    multiSelect: false,    //多选
                    backColor : '#DCDCDC',
                    onNodeChecked: function (event,data) {
                    },
                    onNodeSelected: function (event, data) {
                    	if (data.href != null && data.href != ''){
                    		addContentTabs(data);
                    	}
                    }
                });
			}
		},
		error:function(xhr,textStatus){
		},
		complete:function(){
		}
	});
}

function addContentTabs(data){
	$("#systemContentTabs").data("tabs").addTab({id: data.id, text: data.text, closeable: true, url: data.href})
}

function nodeChecked(event, node) {
	console.log(1);
	console.log(event);
	console.log(node);
}