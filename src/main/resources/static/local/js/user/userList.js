var userUserListDataTable = null;
var lastIdx = null;
$(function () {
	userUserListDataTable = $('#userUserListDataTable').DataTable({
		ajax: {
			url: '/customer/datatable',
			type: 'GET',
			dataSrc: function (json) {
				return json.obj.data;
			}
		},
		serverSide: false,
		language: {
			"sProcessing": "处理中...",
			"sLengthMenu": "显示 _MENU_ 项结果",
			"sZeroRecords": "没有匹配结果",
			"sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
			"sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
			"sInfoFiltered": "(由 _MAX_ 项结果过滤)",
			"sInfoPostFix": "",
			"sSearch": "搜索:",
			"sUrl": "",
			"sEmptyTable": "表中数据为空",
			"sLoadingRecords": "载入中...",
			"sInfoThousands": ",",
			"oPaginate": {
				"sFirst": "首页",
				"sPrevious": "上页",
				"sNext": "下页",
				"sLast": "末页"
			},
			"oAria": {
				"sSortAscending": ": 以升序排列此列",
				"sSortDescending": ": 以降序排列此列"
			}
		},
		//scrollY: 50,//表格里使用滚动
		//使用对象数组，一定要配置columns，告诉 DataTables 每列对应的属性
		//data 这里是固定不变的，name，position，salary，office 为你数据里对应的属性
		columns: [
			{ data: 'cusName',title:'姓名' },
			{ data: 'cusSex',title:'性别' },
			{ data: 'cusOpenId',title:'openid' },
			{ data: 'activeFlag',title:'状态' }
			]
	});

	$('#userUserListDataTable tbody')
	.on( 'mouseover', 'td', function () {
		var colIdx = userUserListDataTable.cell(this).index().column;
		if ( colIdx !== lastIdx ) {
			$( userUserListDataTable.cells().nodes() ).removeClass( 'highlight' );
			$( userUserListDataTable.column( colIdx ).nodes() ).addClass( 'highlight' );
		}
	} )
	.on( 'click', 'tr', function () {
		$(this).toggleClass('selected');
	})
	.on( 'mouseleave', function () {
		$(userUserListDataTable.cells().nodes() ).removeClass( 'highlight' );
	});
});
