<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
var menus = [{
	"backMenu": [{
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "用户信息",
			"menuJump": "列表",
			"tableName": "yonghu"
		}],
		"menu": "用户信息"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "车辆信息",
			"menuJump": "列表",
			"tableName": "cheliang"
		}],
		"menu": "车辆管理"
	}, {
		"child": [{
			"buttons": ["删除"],
			"menu": "租赁信息",
			"menuJump": "列表",
			"tableName": "zulin"
		}],
		"menu": "租赁管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "合同信息",
			"menuJump": "列表",
			"tableName": "hetong"
		}],
		"menu": "合同管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "新闻资讯",
			"menuJump": "列表",
			"tableName": "news"
		},
		{
			"buttons": ["新增", "修改", "删除"],
			"menu": "轮播图",
			"menuJump": "列表",
			"tableName": "lunbotuguanli"
		}],
		"menu": "系统设置"
	}],
	"frontMenu": [],
	"hasBackLogin": "是",
	"hasBackRegister": "否",
	"hasFrontLogin": "否",
	"hasFrontRegister": "否",
	"roleName": "管理员",
	"tableName": "users"
},
{
	"backMenu": [{
		"child": [{
			"buttons": ["租赁"],
			"menu": "车辆信息",
			"menuJump": "列表",
			"tableName": "cheliang"
		}],
		"menu": "车辆管理"
	}, {
		"child": [{
			"buttons": ["还车"],
			"menu": "租赁信息",
			"menuJump": "列表",
			"tableName": "zulin"
		}],
		"menu": "租赁管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "合同信息",
			"menuJump": "列表",
			"tableName": "hetong"
		}],
		"menu": "合同管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "新闻资讯",
			"menuJump": "列表",
			"tableName": "news"
		}],
		"menu": "新闻资讯"
	}],
	"frontMenu": [],
	"hasBackLogin": "是",
	"hasBackRegister": "否",
	"hasFrontLogin": "否",
	"hasFrontRegister": "否",
	"roleName": "用户",
	"tableName": "yonghu"
}
];

var hasMessage = '';
