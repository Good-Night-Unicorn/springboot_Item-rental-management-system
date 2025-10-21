const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot70ps7jmq/",
            name: "springboot70ps7jmq",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot70ps7jmq/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于SpringBoot+Vue的物品租赁管理系统的设计与实现"
        } 
    }
}
export default base
