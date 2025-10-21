<template>
	<div>
		<div class="login-container">
			<video autoplay muted loop>
				<source src='http://codegen.caihongy.cn/20241022/175d32536d554ec6812b6f4af4c6dee1.mp4' type="video/mp4">
				<source src='http://codegen.caihongy.cn/20241022/175d32536d554ec6812b6f4af4c6dee1.mp4' type="video/ogg">
				您的浏览器不支持 video 标签。
			</video>
			<el-form class="login_form animate__animated animate__backInDown">
				<div class="login_form2">
					<div class="title-container">基于SpringBoot+Vue的物品租赁管理系统的设计与实现</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							账号：
						</div>
						<input placeholder="请输入账号：" name="username" type="text" v-model="rulesForm.username">
					</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							密码：
						</div>
						<div class="password-box">
							<input placeholder="请输入密码：" name="password" :type="showPassword?'text':'password'" v-model="rulesForm.password">
							<span class="icon iconfont" :class="showPassword?'icon-liulan13':'icon-liulan17'" @click="showPassword=!showPassword"></span>
						</div>
					</div>

					<div class="list-item " v-if="roles.length>1">
						<div class="lable">
							角色：
						</div>
						<div prop="loginInRole" class="list-type">
							<el-radio v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
						</div>
					</div>

		
					<div class="login-btn">
						<div class="login-btn1">
							<el-button v-if="loginType==1" type="primary" @click="login()" class="loginInBt">登录</el-button>
						</div>
						<div class="login-btn2">
						</div>
						<div class="login-btn3">
						</div>
					</div>
				</div>
				<div class="idea-box2">输入您的账号和密码以访问帐户</div>
			</el-form>
		</div>
	</div>
</template>
<script>
	import 'animate.css'
	import menu from "@/utils/menu";
	export default {
		data() {
			return {
				verifyCheck2: false,
				flag: false,
				baseUrl:this.$base.url,
				loginType: 1,
				rulesForm: {
					username: "",
					password: "",
					role: "",
				},
				menus: [],
				roles: [],
				tableName: "",
				showPassword: false,
			};
		},
		mounted() {
			let menus = menu.list();
			this.menus = menus;

			for (let i = 0; i < this.menus.length; i++) {
				if (this.menus[i].hasBackLogin=='是') {
					this.roles.push(this.menus[i])
				}
			}

		},
		created() {

		},
		destroyed() {
		},
		components: {
		},
		methods: {

			//注册
			register(tableName){
				this.$storage.set("loginTable", tableName);
				this.$router.push({path:'/register',query:{pageFlag:'register'}})
			},
			// 登陆
			login() {

				if (!this.rulesForm.username) {
					this.$message.error("请输入用户名");
					return;
				}
				if (!this.rulesForm.password) {
					this.$message.error("请输入密码");
					return;
				}
				if(this.roles.length>1) {
					if (!this.rulesForm.role) {
						this.$message.error("请选择角色");
						return;
					}

					let menus = this.menus;
					for (let i = 0; i < menus.length; i++) {
						if (menus[i].roleName == this.rulesForm.role) {
							this.tableName = menus[i].tableName;
						}
					}
				} else {
					this.tableName = this.roles[0].tableName;
					this.rulesForm.role = this.roles[0].roleName;
				}
		
				this.loginPost()
			},
			loginPost() {
				this.$http({
					url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
					method: "post"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.$storage.set("Token", data.token);
						this.$storage.set("role", this.rulesForm.role);
						this.$storage.set("sessionTable", this.tableName);
						this.$storage.set("adminName", this.rulesForm.username);
						if(this.boardAuth('hasBoard','查看',this.rulesForm.role)) {
							this.$router.replace({ path: "/board" });
						}else {
							this.$router.replace({ path: "/" });
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
		}
	}
</script>

<style lang="scss" scoped>
.login-container {
	min-height: 100vh;
	position: relative;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	padding: 60px 0 ;
	background-repeat: no-repeat;
	background-size: cover;
	background: linear-gradient( 135deg, #21A5F4 0%, #21A5F4 0%, #2615BC 0%, #2615BC 0%, #228CEB 100%);
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;
	background-position: center center;

	video {
		transform: translate3d(-50%, -50%, 0);
		margin: auto;
		z-index: auto;
		top: 50%;
		left: 50%;
		object-fit: cover;
		width: 100%;
		position: absolute;
		height: 100%;
	}
	.login_form {
		padding: 10% 6% ;
		margin: 0;
		z-index: 1000;
		background-size: cover;
		display: flex;
		flex-wrap: wrap;
		border-radius: 0;
		background-repeat: no-repeat;
		flex-direction: column;
		background: url(http://codegen.caihongy.cn/20241017/c1556ac5c80c47598f18f1693608ea51.png)  no-repeat  left top /  100% 100%;
		width: 815px;
		align-items: flex-start;
		position: relative;
		.login_form2 {
			padding: 0;
			width: 100%;
		}
		.title-container {
			margin: 0 0 20px 0;
			color: #FFFFFF;
			top: 15%;
			left: 0;
			background: none;
			font-weight: 500;
			width: 100%;
			font-size: 22px;
			line-height: 40px;
			position: absolute;
			text-align: center;
		}
		.list-item {
			padding: 0;
			margin: 15px 0;
			background: #0C66A9;
			display: flex;
			width: 100%;
			align-items: center;
			position: relative;
			height: 60px;
			.lable {
				border: 0 ;
				z-index: 2;
				color: #fff;
				left: 10px;
				letter-spacing: 1px;
				width: auto;
				font-size: 16px;
				line-height: 60px;
				position: absolute;
				text-align: left;
				min-width: 60px;
				height: 60px;
			}
			input {
				border: 1px solid #1D90C5;
				padding: 0 72px;
				color: #fff;
				flex: 1;
				background: #0C66A9;
				width: 100%;
				font-size: 16px;
				position: absolute;
				height: 60px;
			}
			input:focus {
				border: 1px solid #1D90C5;
				padding: 0 72px;
				color: #fff;
				flex: 1;
				background: #0C66A9;
				width: 100%;
				font-size: 16px;
				position: absolute;
				height: 60px;
			}
			.password-box {
				display: flex;
				width: 100%;
				align-items: center;
				input {
					border: 1px solid #1D90C5;
					padding: 0 72px;
					outline: none;
					color: #fff;
					flex: 1;
					background: #0C66A9;
					width: 100%;
					font-size: 16px;
					line-height: 60px;
					height: 60px;
				}
				input:focus {
					border: 1px solid #1D90C5;
					padding: 0 72px;
					outline: none;
					color: #fff;
					flex: 1;
					background: #0C66A9;
					width: 100%;
					font-size: 16px;
					line-height: 60px;
					height: 60px;
				}
				.iconfont {
					cursor: pointer;
					z-index: 1;
					color: #fff;
					top: 0;
					font-size: 16px;
					line-height: 60px;
					position: absolute;
					right: 5px;
				}
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
		}
		.list-type {
			border: 1px solid #1D90C5;
			padding: 0 72px;
			outline: none;
			color: #666;
			flex: 1;
			display: flex;
			width: 100%;
			font-size: 16px;
			min-height: 60px;
			align-items: center;
			flex-wrap: wrap;
			height: auto;
			/deep/ .el-radio__input .el-radio__inner {
				background: #fff;
				border-color: #fff;
			}
			/deep/ .el-radio__input.is-checked .el-radio__inner {
				background: #3fb5e3;
				border-color: #3fb5e3;
			}
			/deep/ .el-radio__label {
				color: #fff;
				font-size: 16px;
			}
			/deep/ .el-radio__input.is-checked+.el-radio__label {
				color: #3fb5e3;
				font-size: 16px;
			}
		}
		.login-btn {
			margin: 20px auto;
			display: flex;
			width: 100%;
			justify-content: center;
			align-items: center;
			flex-wrap: wrap;
			.login-btn1 {
				width: 100%;
			}
			.login-btn2 {
				display: flex;
				width: 100%;
				align-items: center;
				flex-wrap: wrap;
			}
			.login-btn3 {
				width: 100%;
			}
			.loginInBt {
				border: 0px solid rgba(0, 0, 0, 1);
				cursor: pointer;
				border-radius: 0px;
				padding: 0 10px;
				margin: 30px 0;
				color: #fff;
				background: #3FB5E3;
				font-weight: 700;
				width: 100%;
				font-size: 22px;
				min-width: 68px;
				height: 60px;
			}
			.loginInBt:hover {
				opacity: 0.8;
			}
			.register {
				border: 1px solid #1D90C5;
				cursor: pointer;
				border-radius: 0;
				padding: 0 10px;
				margin: 0 0 10px;
				color: #fff ;
				background: #1D90C5;
				width: auto;
				font-size: 16px;
				height: 34px;
			}
			.register:hover {
				opacity: 0.8;
			}
			.forget {
				cursor: pointer;
				border-radius: 0;
				padding: 0;
				margin: 0 10px 10px 0;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 0;
				text-align: right;
				height: 34px;
			}
			.forget:hover {
				color: #0d6efd;
				opacity: 1;
			}
		}
	}
	.idea-box2 {
		margin: 5px 0 40px;
		background: #fff;
		display: none;
		width: 100%;
		font-size: 16px;
		height: 30px;
		order: -1;
	}
}

</style>
