># day01 移动架构之六大原则

###**问题：一张图片占多大内存？**
#####六大原则讲解会结合我们自己封装的网络引擎来讲解
###泡在网上的日子：snow这个框架封装可以看看
>回顾：OKhttp使用

1. 第一种简单使用

        OkHttpClient mOkHttpClient = new OkHttpClient();
        Map<String, Object> params = new HashMap<>();
        // 特定参数
        params.put("pageNumber", 1);
        params.put("pageSize", 10);
        // 公共参数
        params.put("app_name", "xxx");
        params.put("version_name", "1.2.3");
          .....
        params.put("device_platform", "android");
        //参数的拼接
        final String jointUrl = Utils.jointParams(ConstantValue.UrlConstant.HOME_DISCOVERY_URL, params);  //打印
        Log.e("Post请求路径：", jointUrl)
        Request.Builder requestBuilder = new Request.Builder().url(jointUrl).tag(this);
        //可以省略，默认是GET请求
        Request request = requestBuilder.build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                // 失败
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String resultJson = response.body().string();
                Log.e("TAG", resultJson);
                // 1.JSON解析转换
                // 2.显示列表数据
                // 3.缓存数据
            }
        });
以上是我们最简单的使用Okhttp的一种方式。