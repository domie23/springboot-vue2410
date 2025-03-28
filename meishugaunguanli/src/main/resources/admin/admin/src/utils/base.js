const base = {
    get() {
        return {
            url : "http://localhost:8080/meishugaunguanli/",
            name: "meishugaunguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/meishugaunguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "美术馆管理系统"
        } 
    }
}
export default base
