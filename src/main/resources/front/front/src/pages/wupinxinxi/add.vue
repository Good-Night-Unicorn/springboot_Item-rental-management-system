<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
			>
			<el-form-item class="add-item" label="物品编号" prop="wupinbianhao">
				<el-input v-model="ruleForm.wupinbianhao" placeholder="物品编号" disabled></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="物品名称" prop="wupinmingcheng">
				<el-input v-model="ruleForm.wupinmingcheng" 
					placeholder="物品名称" clearable :disabled=" false  ||ro.wupinmingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item"  label="物品类别" prop="wupinleibie">
				<el-select v-model="ruleForm.wupinleibie" placeholder="请选择物品类别" :disabled=" false  ||ro.wupinleibie" >
					<el-option
						v-for="(item,index) in wupinleibieOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item" label="图片" v-if="type!='cross' || (type=='cross' && !ro.tupian)" prop="tupian">
				<file-upload
					tip="点击上传图片"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:fileUrls="ruleForm.tupian?ruleForm.tupian:''"
					@change="tupianUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="图片" prop="tupian">
				<img v-if="ruleForm.tupian.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.tupian.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item" label="库存" prop="shuliang">
				<el-input v-model.number="ruleForm.shuliang" 
					placeholder="库存" clearable :disabled=" false  ||ro.shuliang"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="租金" prop="zujin">
				<el-input-number v-model="ruleForm.zujin" placeholder="租金" :disabled=" false ||ro.zujin"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="租赁期限" prop="zulinqixian">
				<el-input v-model="ruleForm.zulinqixian" 
					placeholder="租赁期限" clearable :disabled=" false  ||ro.zulinqixian"></el-input>
			</el-form-item>
			<el-form-item class="add-item"  label="新旧程度" prop="xinjiuchengdu">
				<el-select v-model="ruleForm.xinjiuchengdu" placeholder="请选择新旧程度" :disabled=" false  ||ro.xinjiuchengdu" >
					<el-option
						v-for="(item,index) in xinjiuchengduOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item"  label="租赁状态" prop="zulinzhuangtai">
				<el-select v-model="ruleForm.zulinzhuangtai" placeholder="请选择租赁状态" :disabled=" false  ||ro.zulinzhuangtai" >
					<el-option
						v-for="(item,index) in zulinzhuangtaiOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item" label="租赁流程" prop="zulinliucheng">
				<el-input
					type="textarea"
					:rows="8"
					placeholder="租赁流程"
					v-model="ruleForm.zulinliucheng">
					</el-input>
			</el-form-item>
			<el-form-item class="add-item" label="物品详情" prop="wupinxiangqing">
				<editor 
					v-model="ruleForm.wupinxiangqing" 
					class="editor" 
					action="file/upload">
				</editor>
			</el-form-item>

			<el-form-item class="add-btn-item">
				<el-button class="submitBtn"  type="primary" @click="onSubmit">
					<span class="icon iconfont "></span>
					<span class="text">提交</span>
				</el-button>
				<el-button class="closeBtn" @click="back()">
					<span class="icon iconfont "></span>
					<span class="text">取消</span>
				</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				id: '',
				baseUrl: '',
				ro:{
					wupinbianhao : false,
					wupinmingcheng : false,
					wupinleibie : false,
					tupian : false,
					shuliang : false,
					zujin : false,
					zulinqixian : false,
					xinjiuchengdu : false,
					zulinzhuangtai : false,
					zulinliucheng : false,
					wupinxiangqing : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					wupinbianhao: this.getUUID(),
					wupinmingcheng: '',
					wupinleibie: '',
					tupian: '',
					shuliang: '',
					zujin: '',
					zulinqixian: '',
					xinjiuchengdu: '',
					zulinzhuangtai: '',
					zulinliucheng: '',
					wupinxiangqing: '',
				},
				wupinleibieOptions: [],
				xinjiuchengduOptions: [],
				zulinzhuangtaiOptions: [],


				rules: {
					wupinbianhao: [
					],
					wupinmingcheng: [
					],
					wupinleibie: [
					],
					tupian: [
					],
					shuliang: [
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					zujin: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					zulinqixian: [
					],
					xinjiuchengdu: [
					],
					zulinzhuangtai: [
					],
					zulinliucheng: [
					],
					wupinxiangqing: [
					],
				},
				centerType: false,
			};
		},
		computed: {



		},
		components: {
		},
		created() {
			if(this.$route.query.centerType){
				this.centerType = true
			}
			//this.bg();
			let type = this.$route.query.type ? this.$route.query.type : '';
			this.init(type);
			this.baseUrl = this.$config.baseUrl;
		},
		methods: {
			getMakeZero(s) {
				return s < 10 ? '0' + s : s;
			},
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(type) {
				this.type = type;
				if(type=='cross'){
					var obj = JSON.parse(localStorage.getItem('crossObj'));
					for (var o in obj){
						if(o=='wupinbianhao'){
							this.ruleForm.wupinbianhao = obj[o];
							this.ro.wupinbianhao = true;
							continue;
						}
						if(o=='wupinmingcheng'){
							this.ruleForm.wupinmingcheng = obj[o];
							this.ro.wupinmingcheng = true;
							continue;
						}
						if(o=='wupinleibie'){
							this.ruleForm.wupinleibie = obj[o];
							this.ro.wupinleibie = true;
							continue;
						}
						if(o=='tupian'){
							this.ruleForm.tupian = obj[o].split(",")[0];
							this.ro.tupian = true;
							continue;
						}
						if(o=='shuliang'){
							this.ruleForm.shuliang = obj[o];
							this.ro.shuliang = true;
							continue;
						}
						if(o=='zujin'){
							this.ruleForm.zujin = obj[o];
							this.ro.zujin = true;
							continue;
						}
						if(o=='zulinqixian'){
							this.ruleForm.zulinqixian = obj[o];
							this.ro.zulinqixian = true;
							continue;
						}
						if(o=='xinjiuchengdu'){
							this.ruleForm.xinjiuchengdu = obj[o];
							this.ro.xinjiuchengdu = true;
							continue;
						}
						if(o=='zulinzhuangtai'){
							this.ruleForm.zulinzhuangtai = obj[o];
							this.ro.zulinzhuangtai = true;
							continue;
						}
						if(o=='zulinliucheng'){
							this.ruleForm.zulinliucheng = obj[o];
							this.ro.zulinliucheng = true;
							continue;
						}
						if(o=='wupinxiangqing'){
							this.ruleForm.wupinxiangqing = obj[o];
							this.ro.wupinxiangqing = true;
							continue;
						}
					}
				}else if(type=='edit'){
					this.info()
				}
				// 获取用户信息
				this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						var json = res.data.data;
					}
				});
				this.$http.get('option/wupinleibie/wupinleibie', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.wupinleibieOptions = res.data.data;
					}
				});
				this.xinjiuchengduOptions = "全新,九成新,七成新,其他".split(',')
				this.zulinzhuangtaiOptions = "已租赁,可租赁".split(',')

				if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
					localStorage.removeItem('raffleType')
					setTimeout(() => {
						this.onSubmit()
					}, 300)
				}
			},

			// 多级联动参数
			// 多级联动参数
			info() {
				this.$http.get(`wupinxinxi/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.ruleForm = res.data.data;
					}
				});
			},
			// 提交
			async onSubmit() {
				if(this.ruleForm.wupinbianhao){
					this.ruleForm.wupinbianhao = String(this.ruleForm.wupinbianhao)
				}
				await this.$refs["ruleForm"].validate(async valid => {
					if(valid) {
						if(this.type=='cross'){
							var statusColumnName = localStorage.getItem('statusColumnName');
							var statusColumnValue = localStorage.getItem('statusColumnValue');
							if(statusColumnName && statusColumnName!='') {
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								if(!statusColumnName.startsWith("[")) {
									for (var o in obj){
										if(o==statusColumnName){
											obj[o] = statusColumnValue;
										}
									}
									var table = localStorage.getItem('crossTable');
									await this.$http.post(table+'/update', obj).then(res => {});
								}
							}
						}


						await this.$http.post(`wupinxinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
										
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.$router.go(-1);
			},
			tupianUploadChange(fileUrls) {
				this.ruleForm.tupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
			},
		}
	};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.add-update-preview {
		padding: 0 calc((100% - 1200px)/2) 20px;
		margin: 0px auto;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 16px;
		position: relative;
		.add-update-form {
			border: 1px solid rgb(25, 190, 212);
			padding: 40px 20px;
			margin: 0px auto;
			background: #fff;
			width: 100%;
			position: relative;
			.add-item.el-form-item {
				border-radius: 0px;
				padding: 6px 0 0;
				margin: 0 0 20px 0;
				background: none;
				border-color: #475a8310;
				border-width:  0 0 0px;
				border-style: solid;
				/deep/ .el-form-item__label {
					padding: 0 10px 0 0;
					color: #666;
					font-weight: 500;
					width: 180px;
					font-size: inherit;
					line-height: 40px;
					text-align: right;
				}
				/deep/ .el-form-item__content {
					margin-left: 180px;
				}
				.el-input {
					width: auto;
				}
				.el-input /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 4px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input__inner {
					text-align: left;
					border: 1px solid #ddd;
					border-radius: 4px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .is-disabled .el-input__inner {
					text-align: left;
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input-number__decrease {
					display: none;
				}
				.el-input-number /deep/ .el-input-number__increase {
					display: none;
				}
				.el-select {
					width: auto;
				}
				.el-select /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 4px;
					padding: 0 10px;
					color: inherit;
					width: 100%;
					font-size: 16px;
					min-width: inherit !important;
					height: 40px;
				}
				.el-select /deep/ .is-disabled .el-input__inner {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor {
					width: auto;
				}
				.el-date-editor /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 4px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				/deep/ .el-upload--picture-card {
					background: transparent;
					border: 0;
					border-radius: 0;
					width: auto;
					height: auto;
					line-height: initial;
					vertical-align: middle;
				}
				/deep/ .upload .upload-img {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 4px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload-list .el-upload-list__item {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 4px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
					font-size: 14px;
					line-height: 1.8;
				}
				/deep/ .el-upload .el-icon-plus {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 4px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload__tip {
					color: #888;
					font-size: 16px;
				}
				.el-textarea /deep/ .el-textarea__inner {
					border: 1px solid #ddd;
					border-radius: 4px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 48%;
					height: auto;
				}
				.el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
					border: 0px solid #ddd;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 50%;
					height: auto;
				}
				/deep/ .el-input__inner::placeholder {
					color: inherit;
					font-size: inherit;
				}
				/deep/ textarea::placeholder {
					color: inherit;
					font-size: inherit;
				}
				.editor {
					background-color: #fff;
					border-radius: 0;
					padding: 0;
					box-shadow: none;
					margin: 0;
					width: 100%;
					min-height: 350px;
					border-color: #ccc;
					border-width: 1px;
					border-style: solid;
					height: auto;
				}
				.upload-img {
					object-fit: cover;
					width: 100px;
					height: 100px;
				}
				.viewBtn {
					border: 0;
					cursor: pointer;
					border-radius: 4px;
					padding: 0 20px;
					margin: 0;
					color: #fff;
					background: rgb(25, 190, 212);
					display: inline-block;
					width: auto;
					font-size: 14px;
					line-height: 34px;
					height: 34px;
				}
				.viewBtn:hover {
				}
				.unviewBtn {
					border: 0;
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					color: #333;
					display: inline-block;
					font-size: 14px;
					line-height: 34px;
					border-radius: 4px;
					outline: none;
					background: #eee;
					width: auto;
					height: 34px;
				}
				.unviewBtn:hover {
				}
			}
			.add-btn-item {
				padding: 0;
				margin: 20px 0;
				text-align: center;
				.submitBtn {
					border: 0;
					cursor: pointer;
					padding: 0 24px;
					margin: 0 20px 0 0;
					display: inline-block;
					font-size: 16px;
					line-height: 40px;
					border-radius: 0px;
					background: rgb(25, 190, 212);
					width: auto;
					text-align: center;
					min-width: 120px;
					height: 40px;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
					}
				}
				.submitBtn:hover {
					.icon {
					}
					.text {
					}
				}
				.closeBtn {
					border: 0px solid #ddd;
					cursor: pointer;
					padding: 0 24px;
					margin: 0 20px 0 0;
					color: #fff;
					display: inline-block;
					font-size: 16px;
					line-height: 40px;
					border-radius: 0px;
					background: rgb(232, 232, 232);
					width: auto;
					text-align: center;
					min-width: 120px;
					height: 40px;
					.icon {
						color: #fff;
					}
					.text {
						color: rgb(110, 110, 110);
					}
				}
				.closeBtn:hover {
					.icon {
					}
					.text {
					}
				}
			}
		}
	}
	.el-date-editor.el-input {
		width: auto;
	}
</style>
