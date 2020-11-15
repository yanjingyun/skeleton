(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-21fe297f","chunk-17ef5105"],{"2f62":function(t,e,s){},"3aa5":function(t,e,s){"use strict";s.r(e);var o=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"search"},[s("Row",[s("Col",[s("Card",[s("Row",{staticClass:"operation"},[s("Button",{directives:[{name:"has",rawName:"v-has",value:"add",expression:"'add'"}],attrs:{type:"primary",icon:"md-add"},on:{click:t.addRole}},[t._v("安排新任务")]),s("Button",{directives:[{name:"has",rawName:"v-has",value:"delete",expression:"'delete'"}],attrs:{icon:"md-trash"},on:{click:t.delAll}},[t._v("批量删除")]),s("Button",{attrs:{icon:"md-refresh"},on:{click:t.init}},[t._v("刷新")]),t.operationLoading?s("circleLoading"):t._e()],1),s("Row",[s("Alert",{attrs:{"show-icon":""}},[t._v("\n                        已选择 "),s("span",{staticClass:"select-count"},[t._v(t._s(t.selectCount))]),t._v(" 项\n                        "),s("a",{staticClass:"select-clear",on:{click:t.clearSelectAll}},[t._v("清空")])])],1),s("Row",[s("Table",{ref:"table",attrs:{loading:t.loading,border:"",columns:t.columns,data:t.data,sortable:"custom"},on:{"on-sort-change":t.changeSort,"on-selection-change":t.changeSelect}})],1),s("Row",{staticClass:"page",attrs:{type:"flex",justify:"end"}},[s("Page",{attrs:{current:t.pageNumber,total:t.total,"page-size":t.pageSize,"page-size-opts":[10,20,50],size:"small","show-total":"","show-elevator":"","show-sizer":""},on:{"on-change":t.changePage,"on-page-size-change":t.changePageSize}})],1)],1)],1)],1),s("Modal",{attrs:{title:t.modalTitle,"mask-closable":!1,width:500},model:{value:t.modalVisible,callback:function(e){t.modalVisible=e},expression:"modalVisible"}},[s("Form",{ref:"form",attrs:{model:t.form,"label-width":80,rules:t.formValidate}},[s("FormItem",{attrs:{label:"任务类名",prop:"jobClassName"}},[s("Input",{attrs:{placeholder:"例如 com.yjy.admin.quartz.jobs.Job",clearable:""},model:{value:t.form.jobClassName,callback:function(e){t.$set(t.form,"jobClassName",e)},expression:"form.jobClassName"}})],1),s("FormItem",{staticStyle:{"margin-bottom":"5px"},attrs:{label:"cron表达式",prop:"cronExpression"}},[s("Input",{attrs:{clearable:""},model:{value:t.form.cronExpression,callback:function(e){t.$set(t.form,"cronExpression",e)},expression:"form.cronExpression"}}),s("a",{attrs:{target:"_blank",href:"http://cron.qqe2.com/"}},[s("Icon",{staticStyle:{margin:"0 3px 3px 0"},attrs:{type:"md-arrow-dropright-circle",size:"16"}}),t._v("\n                    在线cron表达式生成\n                ")],1)],1),s("FormItem",{attrs:{label:"参数",prop:"parameter"}},[s("Input",{model:{value:t.form.parameter,callback:function(e){t.$set(t.form,"parameter",e)},expression:"form.parameter"}})],1),s("FormItem",{attrs:{label:"备注",prop:"description"}},[s("Input",{model:{value:t.form.description,callback:function(e){t.$set(t.form,"description",e)},expression:"form.description"}})],1)],1),s("div",{attrs:{slot:"footer"},slot:"footer"},[s("Button",{attrs:{type:"text"},on:{click:t.cancelSubmit}},[t._v("取消")]),s("Button",{attrs:{type:"primary",loading:t.submitLoading},on:{click:t.handleSubmit}},[t._v("保存并安排")])],1)],1)],1)},i=[],a=(s("6d57"),s("ed63"),s("8cf2"),s("365c")),n=s("8465"),r=s("23d5"),l=s.n(r),c={name:"quartz-manage",components:{circleLoading:n["default"]},data:function(){var t=this;return{loading:!0,operationLoading:!1,sortColumn:"createdAt",sortType:"desc",modalType:0,modalVisible:!1,modalTitle:"",permTypes:[],form:{id:"",paramter:"",description:""},formValidate:{jobClassName:[{required:!0,message:"任务类名不能为空",trigger:"blur"}],cronExpression:[{required:!0,message:"cron表达式不能为空",trigger:"blur"}]},submitLoading:!1,selectList:[],selectCount:0,columns:[{type:"selection",width:60,align:"center"},{type:"index",width:60,align:"center"},{title:"任务类名",key:"jobClassName",sortable:!0,width:200},{title:"cron表达式",key:"cronExpression",sortable:!0},{title:"参数",key:"parameter",sortable:!0},{title:"备注",key:"description",sortable:!0,width:180},{title:"创建时间",key:"createdAt",sortable:!0,sortType:"desc",render:function(t,e){return t("div",l()(1e3*e.row.createdAt).format("YYYY-MM-DD HH:mm:ss"))}},{title:"更新时间",key:"updatedAt",sortable:!0,sortType:"desc",render:function(t,e){return t("div",l()(1e3*e.row.updatedAt).format("YYYY-MM-DD HH:mm:ss"))}},{title:"状态",key:"status",align:"center",width:140,render:function(t,e){return 1===e.row.status?t("div",[t("Tag",{props:{type:"dot",color:"success"}},"执行中")]):0===e.row.status?t("div",[t("Tag",{props:{type:"dot",color:"error"}},"已停止")]):void 0},filters:[{label:"执行中",value:1},{label:"已停止",value:0}],filterMultiple:!1,filterMethod:function(t,e){return 1===t?1===e.status:0===t?0===e.status:void 0}},{title:"操作",key:"action",align:"center",width:280,render:function(e,s){var o,i,a,n;t.permTypes.includes("edit")&&(o=e("Button",{props:{type:"primary",size:"small"},style:{marginRight:"5px"},on:{click:function(){t.edit(s.row)}}},"编辑")),t.permTypes.includes("enable")&&(a=e("Button",{props:{type:"info",size:"small",icon:"md-play"},style:{marginRight:"5px"},on:{click:function(){t.resume(s.row)}}},"恢复执行")),t.permTypes.includes("disable")&&(i=e("Button",{props:{type:"warning",size:"small",icon:"md-pause"},style:{marginRight:"5px"},on:{click:function(){t.pause(s.row)}}},"暂停")),t.permTypes.includes("delete")&&(n=e("Button",{props:{type:"error",size:"small"},on:{click:function(){t.remove(s.row)}}},"删除"));var r="";return r=1==s.row.status?i:a,e("div",[r,o,n])}}],data:[],pageNumber:1,pageSize:10,total:0}},methods:{init:function(){this.getQuartzList(),this.initMeta()},changePage:function(t){this.pageNumber=t,this.getQuartzList(),this.clearSelectAll()},changePageSize:function(t){this.pageSize=t,this.getQuartzList()},changeSort:function(t){this.sortColumn=t.key,this.sortType=t.order,"normal"===t.order&&(this.sortType=""),this.getQuartzList()},getQuartzList:function(){var t=this;this.loading=!0;var e={pageNumber:this.pageNumber,pageSize:this.pageSize,sort:this.sortColumn,order:this.sortType};Object(a["P"])(e).then((function(e){t.loading=!1,!0===e.success&&(t.data=e.result.records,t.total=e.result.total)}))},cancelSubmit:function(){this.modalVisible=!1},handleSubmit:function(){var t=this;this.$refs.form.validate((function(e){e&&(0===t.modalType?(t.submitLoading=!0,Object(a["e"])(t.form).then((function(e){t.submitLoading=!1,!0===e.success&&(t.$Message.success("操作成功"),t.getQuartzList(),t.modalVisible=!1)}))):(t.submitLoading=!0,Object(a["A"])(t.form).then((function(e){t.submitLoading=!1,!0===e.success&&(t.$Message.success("操作成功"),t.getQuartzList(),t.modalVisible=!1)}))))}))},addRole:function(){this.modalType=0,this.modalTitle="添加任务",this.$refs.form.resetFields(),this.form={paramter:"",description:""},this.modalVisible=!0},edit:function(t){for(var e in this.modalType=1,this.modalTitle="编辑任务",t)null===t[e]&&(t[e]="");var s=JSON.stringify(t),o=JSON.parse(s);this.form=o,this.modalVisible=!0},pause:function(t){var e=this;this.$Modal.confirm({title:"确认停止",content:"您确认要停止任务 "+t.jobClassName+" ?",onOk:function(){e.operationLoading=!0,Object(a["bb"])(t).then((function(t){e.operationLoading=!1,!0===t.success&&(e.$Message.success("操作成功"),e.getQuartzList())}))}})},resume:function(t){var e=this;this.$Modal.confirm({title:"确认恢复",content:"您确认要恢复任务 "+t.jobClassName+" ?",onOk:function(){e.operationLoading=!0,Object(a["cb"])(t).then((function(t){e.operationLoading=!1,!0===t.success&&(e.$Message.success("操作成功"),e.getQuartzList())}))}})},remove:function(t){var e=this;this.$Modal.confirm({title:"确认删除",content:"您确认要删除任务 "+t.jobClassName+" ?",onOk:function(){e.operationLoading=!0,Object(a["p"])(t.id).then((function(t){e.operationLoading=!1,!0===t.success&&(e.$Message.success("操作成功"),e.getQuartzList())}))}})},clearSelectAll:function(){this.$refs.table.selectAll(!1)},changeSelect:function(t){this.selectList=t,this.selectCount=t.length},delAll:function(){var t=this;this.selectCount<=0?this.$Message.warning("您还未选择要删除的数据"):this.$Modal.confirm({title:"确认删除",content:"您确认要删除所选的 "+this.selectCount+" 条数据?",onOk:function(){var e="";t.selectList.forEach((function(t){e+=t.id+","})),e=e.substring(0,e.length-1),t.operationLoading=!0,Object(a["p"])(e).then((function(e){t.operationLoading=!1,!0===e.success&&(t.$Message.success("删除成功"),t.clearSelectAll(),t.getQuartzList())}))}})},initMeta:function(){var t=this.$route.meta.permTypes;null!==t&&void 0!==t&&(this.permTypes=t)}},mounted:function(){this.init()}},u=c,d=(s("443b"),s("e90a")),m=Object(d["a"])(u,o,i,!1,null,null,null);e["default"]=m.exports},"443b":function(t,e,s){"use strict";var o=s("781a"),i=s.n(o);i.a},"781a":function(t,e,s){},8364:function(t,e,s){"use strict";var o=s("2f62"),i=s.n(o);i.a},8465:function(t,e,s){"use strict";s.r(e);var o=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticStyle:{display:"inline-block"}},[s("Icon",{staticClass:"spin-icon-load",attrs:{type:"ios-loading",size:"18",color:"#2d8cf0"}})],1)},i=[],a={name:"circleLoading"},n=a,r=(s("8364"),s("e90a")),l=Object(r["a"])(n,o,i,!1,null,null,null);e["default"]=l.exports}}]);