package com.xiyuxian.imagesearch.sub;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONUtil;
import com.xiyuxian.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import com.xiyuxian.exception.ErrorCode;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class GetImagePageUrlApi {

    /**
     * 获取图片页面地址
     *
     * @param imageUrl
     * @return
     */
    public static String getImagePageUrl(String imageUrl) {
        // image: https%3A%2F%2Fwww.codefather.cn%2Flogo.png
        //tn: pc
        //from: pc
        //image_source: PC_UPLOAD_URL
        //sdkParams:
        // 1. 准备请求参数
        Map<String, Object> formData = new HashMap<>();
        formData.put("image", imageUrl);
        formData.put("tn", "pc");
        formData.put("from", "pc");
        formData.put("image_source", "PC_UPLOAD_URL");
        // 获取当前时间戳
        long uptime = System.currentTimeMillis();
        // 请求地址
        String url = "https://graph.baidu.com/upload?uptime=" + uptime;
        try {
            // 2. 发送请求
            HttpResponse httpResponse = HttpRequest.post(url)
                    .header("Acs-Token", "1740112329987_1740146496215_ZYnQfRo1x4ICqwqiDhjuW6rZqEMAdq7Ee7foME7fHXE2qtAsOhHOhtOE5Y3os1mWa+Gr/hGPXUGEQDJ0Vs8OIO8/bxewmHvg9NsZrzM87h0F+a6cz6TnKOVhNA9f+f1BZsWF0QybUgL8RN6DBcU7v4ec/FTZR5XeyV8yuQnbgIAzNbYHGWV4VztlKXQhPo0gmD2ugBBt5Rxo/BU2oMAm1vXiZFHQhOJIADk/rI03b5nyM6LrL0TdI/exdvFza2P/KzJTKB6NQUB4x2bcYC1j8njhMgWz6HeYAI7pFdqpATIRkdtObhh1QlrCogrSFnIgt7q5dge+9H/ob4v/Na136CezU3zwaVcCwnP6NXjNHsVHtU8OzytR+Hvj1X0gxDHCJD5W7NpSTz5J+SKqI3OBa1pgw9JuXeVwyugI0ljWNiFi9D5IcgiFi/gF2a/kzU9z")
                    .form(formData)
                    .timeout(5000)
                    .execute();
            if (httpResponse.getStatus() != HttpStatus.HTTP_OK) {
                throw new BusinessException(ErrorCode.OPERATTION_ERROR, "接口调用失败");
            }
            // 解析响应
            // {"status":0,"msg":"Success","data":{"url":"https://graph.baidu.com/sc","sign":"1262fe97cd54acd88139901734784257"}}
            String body = httpResponse.body();
            Map<String, Object> result = JSONUtil.toBean(body, Map.class);
            // 3. 处理响应结果
            if (result == null || !Integer.valueOf(0).equals(result.get("status"))) {
                throw new BusinessException(ErrorCode.OPERATTION_ERROR, "接口调用失败");
            }
            Map<String, Object> data = (Map<String, Object>) result.get("data");
            // 对 URL 进行解码
            String rawUrl = (String) data.get("url");
            String searchResultUrl = URLUtil.decode(rawUrl, StandardCharsets.UTF_8);
            // 如果 URL 为空
            if (StrUtil.isBlank(searchResultUrl)) {
                throw new BusinessException(ErrorCode.OPERATTION_ERROR, "未返回有效的结果地址");
            }
            return searchResultUrl;
        } catch (Exception e) {
            log.error("调用百度以图搜图接口失败", e);
            throw new BusinessException(ErrorCode.OPERATTION_ERROR, "搜索失败");
        }
    }

    public static void main(String[] args) {
        // 测试以图搜图功能
        String imageUrl = "https://www.codefather.cn/logo.png";
        String searchResultUrl = getImagePageUrl(imageUrl);
        System.out.println("搜索成功，结果 URL：" + searchResultUrl);
    }
}