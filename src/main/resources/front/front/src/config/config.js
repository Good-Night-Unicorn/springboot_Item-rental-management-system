export default {
	baseUrl: 'http://localhost:8080/springboot70ps7jmq/',
	name: '/springboot70ps7jmq',
	indexNav: [
// frontMenu com.jlwl.entity.Menu@fc5d735
		{
			name: '物品信息',
			url: '/index/wupinxinxi',
		},
		{
			name: '公告信息',
			url: '/index/news'
		},
	],
	cateList: [
		{
			name: '公告信息',
			refTable: 'newstype',
			refColumn: 'typename',
		},
	]
}
