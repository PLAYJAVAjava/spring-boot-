const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootwy9os/",
            name: "springbootwy9os",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootwy9os/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于SpringBoot的电脑商城管理系统"
        } 
    }
}
export default base
