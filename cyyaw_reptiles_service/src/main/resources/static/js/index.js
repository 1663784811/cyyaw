new Vue({
    el: '#app',
    data: {
        maincontent: 'main',
        imgData: [],
        reptilesInfo: {},
        searchRest: [],
        searchPage: {
            page: 1,
            size: 10,
            total: 0
        },
        showRest: false,
        findRestData: {
            tid:''
        },
        echarSpeed: null,
        speedPic: null,
        speedTable: null
    },
    mounted: function () {
        this.threadInfoRun();
        this.getImgList();
        this.searchFn();
        this.echarSpeed = echarts.init(this.$refs.echarSpeed);
        this.speedPic = echarts.init(this.$refs.speedPic);
        this.speedTable = echarts.init(this.$refs.speedTable);
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: 'ECharts 入门示例'
            },
            tooltip: {},
            legend: {
                data: ['销量']
            },
            xAxis: {
                data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }]
        };
        this.echarSpeed.setOption(option);

        var option1 = {
            xAxis: {
                type: 'category',
                data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                data: [820, 932, 901, 934, 1290, 1330, 1320],
                type: 'line'
            }]
        };

        this.speedPic.setOption(option1);

        let option2 = {
            tooltip: {
                formatter: '{a} <br/>{b} : {c}%'
            },
            toolbox: {
                feature: {
                    restore: {},
                    saveAsImage: {}
                }
            },
            series: [
                {
                    name: '业务指标',
                    type: 'gauge',
                    detail: {formatter: '{value}%'},
                    data: [{value: 50, name: '完成率'}]
                }
            ]
        };
        this.speedTable.setOption(option2);
    },
    methods: {
        clickSearchRest(obj) {
            let that = this;
            that.findRestData = obj;
            that.showRest = true;
        },
        /**
         *
         */
        clickSearch() {
            this.maincontent = 'search';
            this.searchPage.total = 0;
            this.searchPage.page = 1;
            this.searchFn();
        },
        onchangePageFn(page){
            this.searchPage.page = page;
            this.searchFn();
        },
        searchFn() {
            let that = this;
            let param = {
                page: this.searchPage.page,
                size: this.searchPage.size
            }
            GetRequest('/search/searchContent', param).then(function (data) {
                that.searchRest = data.data;
                that.searchPage = data.result;
            })
        },
        /**
         */
        showType: function (type) {
            this.maincontent = type;
        },
        /**
         * 更新线程信息
         */
        threadInfoRun: function () {
            setInterval(this.threadInfo, 2000);
        },
        /**
         * 获取线程信息
         */
        threadInfo: function () {
            var that = this;
            GetRequest('/reptiles/threadInfo').then(function (data) {
                that.reptilesInfo = data;
            })
        },
        /**
         *
         */
        getImgList: function () {
            var that = this;
            GetRequest('/img/getImgList', {
                page: 1,
                size: 100
            }).then(function (data) {
                that.imgData = data.data;
            })
        }
    }
});
