package mjoys.com.day01liudayuanze.type03;

import java.util.List;

/**
 * Created by zsd on 2018/1/4 17:07
 * desc:
 */

public class SelfProductBean {

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * goodsId : 27
         * goodsSn : test
         * goodsName : highsea-test
         * categoryId : 2
         * brandId : 1
         * goodsType : 2
         * extInfo : sdsadadsada
         * goodsStock : 23
         * goodsOriginalPrice : 1200
         * goodsCurrentPrice : 1000
         * isNew : 1
         * isHot : 1
         * isPromote : 1
         * installmentInfo : {"periodNum":2,"repaymentAmount":522.62,"interest":22.63,"desc":"分期购:￥522.62 x 2期"}
         * imageInfo : {"normalImgUrl":"http://img.mxassets.com/img_upload/2017/12/28/201712281424250531N21.png","thumbImgUrl":"http://img.mxassets.com/img_upload/2017/12/28/201712281424250531N21.png"}
         */

        private int goodsId;
        private String goodsSn;
        private String goodsName;
        private int categoryId;
        private int brandId;
        private int goodsType;
        private String extInfo;
        private int goodsStock;
        private int goodsOriginalPrice;
        private int goodsCurrentPrice;
        private int isNew;
        private int isHot;
        private int isPromote;
        private InstallmentInfoBean installmentInfo;
        private ImageInfoBean imageInfo;

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public String getGoodsSn() {
            return goodsSn;
        }

        public void setGoodsSn(String goodsSn) {
            this.goodsSn = goodsSn;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public int getBrandId() {
            return brandId;
        }

        public void setBrandId(int brandId) {
            this.brandId = brandId;
        }

        public int getGoodsType() {
            return goodsType;
        }

        public void setGoodsType(int goodsType) {
            this.goodsType = goodsType;
        }

        public String getExtInfo() {
            return extInfo;
        }

        public void setExtInfo(String extInfo) {
            this.extInfo = extInfo;
        }

        public int getGoodsStock() {
            return goodsStock;
        }

        public void setGoodsStock(int goodsStock) {
            this.goodsStock = goodsStock;
        }

        public int getGoodsOriginalPrice() {
            return goodsOriginalPrice;
        }

        public void setGoodsOriginalPrice(int goodsOriginalPrice) {
            this.goodsOriginalPrice = goodsOriginalPrice;
        }

        public int getGoodsCurrentPrice() {
            return goodsCurrentPrice;
        }

        public void setGoodsCurrentPrice(int goodsCurrentPrice) {
            this.goodsCurrentPrice = goodsCurrentPrice;
        }

        public int getIsNew() {
            return isNew;
        }

        public void setIsNew(int isNew) {
            this.isNew = isNew;
        }

        public int getIsHot() {
            return isHot;
        }

        public void setIsHot(int isHot) {
            this.isHot = isHot;
        }

        public int getIsPromote() {
            return isPromote;
        }

        public void setIsPromote(int isPromote) {
            this.isPromote = isPromote;
        }

        public InstallmentInfoBean getInstallmentInfo() {
            return installmentInfo;
        }

        public void setInstallmentInfo(InstallmentInfoBean installmentInfo) {
            this.installmentInfo = installmentInfo;
        }

        public ImageInfoBean getImageInfo() {
            return imageInfo;
        }

        public void setImageInfo(ImageInfoBean imageInfo) {
            this.imageInfo = imageInfo;
        }

        public static class InstallmentInfoBean {
            /**
             * periodNum : 2
             * repaymentAmount : 522.62
             * interest : 22.63
             * desc : 分期购:￥522.62 x 2期
             */

            private int periodNum;
            private double repaymentAmount;
            private double interest;
            private String desc;

            public int getPeriodNum() {
                return periodNum;
            }

            public void setPeriodNum(int periodNum) {
                this.periodNum = periodNum;
            }

            public double getRepaymentAmount() {
                return repaymentAmount;
            }

            public void setRepaymentAmount(double repaymentAmount) {
                this.repaymentAmount = repaymentAmount;
            }

            public double getInterest() {
                return interest;
            }

            public void setInterest(double interest) {
                this.interest = interest;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }

        public static class ImageInfoBean {
            /**
             * normalImgUrl : http://img.mxassets.com/img_upload/2017/12/28/201712281424250531N21.png
             * thumbImgUrl : http://img.mxassets.com/img_upload/2017/12/28/201712281424250531N21.png
             */

            private String normalImgUrl;
            private String thumbImgUrl;

            public String getNormalImgUrl() {
                return normalImgUrl;
            }

            public void setNormalImgUrl(String normalImgUrl) {
                this.normalImgUrl = normalImgUrl;
            }

            public String getThumbImgUrl() {
                return thumbImgUrl;
            }

            public void setThumbImgUrl(String thumbImgUrl) {
                this.thumbImgUrl = thumbImgUrl;
            }
        }
    }
}
