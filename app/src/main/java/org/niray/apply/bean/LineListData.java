package org.niray.apply.bean;

/**
 * Created by Chen Zhining
 * Date : 16/10/17.
 */

public class LineListData extends BaseJsonModel<PageJsonModel<LineListData.LineListDetail>> {
    public class LineListDetail {
        private int id;
        private int type;
        private String name;
        private String price;
        private int lowest_event_id;
        private int uid;
        private int club_id;
        private int leader_id;
        private String short_description;
        private String from_district;
        private String destination_district;
        private String address;
        private int cover_image;
        private String banner_image;
        private int is_distribute;
        private String distribute_cost;
        private int strength;
        private String apply_extend_field;
        private String link_rewrite;
        private int status;
        private int collect_num;
        private String created_at;
        private int sort;
        private String slogan;
        private String linkman_name;
        private String linkman_mobile;
        private Object conver_image_new;
        private int sort_by_club;
        private String linkman_qq;
        /**
         * uid : 1261136
         * nickname : 果冻1
         */

        private UidInfoEntity uid_info;
        /**
         * city : {"no":"110101","parent_no":"110000","area_name":"东城区","area_postcode":"010","area_level":"2"}
         * province : {"no":"110000","parent_no":"0","area_name":"北京市","area_postcode":"010","area_level":"1"}
         */

        private FromDistrictInfoEntity from_district_info;
        /**
         * city : {"no":"360400","parent_no":"360000","area_name":"九江市","area_postcode":"0792","area_level":"2"}
         * province : {"no":"360000","parent_no":"0","area_name":"江西省","area_postcode":"","area_level":"1"}
         */

        private DestinationDistrictInfoEntity destination_district_info;
        /**
         * id : 116402
         * original : 7.jpg
         * url : http://thumb.huway.com/huway/upload/2016/10/16/20161016195056663372.jpg
         */

        private CoverImageInfoEntity cover_image_info;

        /**
         * 0 : {"25428":{"id":25428,"name":"雪峰户外","price":"450.00","maxMember":100,"presentMember":50,"haveApply":50,"remainNum":50}}
         * max_Member : 100
         * remainNum : 50
         * present_Member : 50
         * haveApply : 50
         */


        public class UidInfoEntity {
            private int uid;
            private String nickname;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }
        }

        public class FromDistrictInfoEntity {
            /**
             * no : 110101
             * parent_no : 110000
             * area_name : 东城区
             * area_postcode : 010
             * area_level : 2
             */

            private CityEntity city;
            /**
             * no : 110000
             * parent_no : 0
             * area_name : 北京市
             * area_postcode : 010
             * area_level : 1
             */

            private ProvinceEntity province;

            public CityEntity getCity() {
                return city;
            }

            public void setCity(CityEntity city) {
                this.city = city;
            }

            public ProvinceEntity getProvince() {
                return province;
            }

            public void setProvince(ProvinceEntity province) {
                this.province = province;
            }

            public class CityEntity {
                private String no;
                private String parent_no;
                private String area_name;
                private String area_postcode;
                private String area_level;

                public String getNo() {
                    return no;
                }

                public void setNo(String no) {
                    this.no = no;
                }

                public String getParent_no() {
                    return parent_no;
                }

                public void setParent_no(String parent_no) {
                    this.parent_no = parent_no;
                }

                public String getArea_name() {
                    return area_name;
                }

                public void setArea_name(String area_name) {
                    this.area_name = area_name;
                }

                public String getArea_postcode() {
                    return area_postcode;
                }

                public void setArea_postcode(String area_postcode) {
                    this.area_postcode = area_postcode;
                }

                public String getArea_level() {
                    return area_level;
                }

                public void setArea_level(String area_level) {
                    this.area_level = area_level;
                }
            }

            public class ProvinceEntity {
                private String no;
                private String parent_no;
                private String area_name;
                private String area_postcode;
                private String area_level;

                public String getNo() {
                    return no;
                }

                public void setNo(String no) {
                    this.no = no;
                }

                public String getParent_no() {
                    return parent_no;
                }

                public void setParent_no(String parent_no) {
                    this.parent_no = parent_no;
                }

                public String getArea_name() {
                    return area_name;
                }

                public void setArea_name(String area_name) {
                    this.area_name = area_name;
                }

                public String getArea_postcode() {
                    return area_postcode;
                }

                public void setArea_postcode(String area_postcode) {
                    this.area_postcode = area_postcode;
                }

                public String getArea_level() {
                    return area_level;
                }

                public void setArea_level(String area_level) {
                    this.area_level = area_level;
                }
            }
        }

        public class DestinationDistrictInfoEntity {
            /**
             * no : 360400
             * parent_no : 360000
             * area_name : 九江市
             * area_postcode : 0792
             * area_level : 2
             */

            private CityEntity city;
            /**
             * no : 360000
             * parent_no : 0
             * area_name : 江西省
             * area_postcode :
             * area_level : 1
             */

            private ProvinceEntity province;

            public CityEntity getCity() {
                return city;
            }

            public void setCity(CityEntity city) {
                this.city = city;
            }

            public ProvinceEntity getProvince() {
                return province;
            }

            public void setProvince(ProvinceEntity province) {
                this.province = province;
            }

            public class CityEntity {
                private String no;
                private String parent_no;
                private String area_name;
                private String area_postcode;
                private String area_level;

                public String getNo() {
                    return no;
                }

                public void setNo(String no) {
                    this.no = no;
                }

                public String getParent_no() {
                    return parent_no;
                }

                public void setParent_no(String parent_no) {
                    this.parent_no = parent_no;
                }

                public String getArea_name() {
                    return area_name;
                }

                public void setArea_name(String area_name) {
                    this.area_name = area_name;
                }

                public String getArea_postcode() {
                    return area_postcode;
                }

                public void setArea_postcode(String area_postcode) {
                    this.area_postcode = area_postcode;
                }

                public String getArea_level() {
                    return area_level;
                }

                public void setArea_level(String area_level) {
                    this.area_level = area_level;
                }
            }

            public class ProvinceEntity {
                private String no;
                private String parent_no;
                private String area_name;
                private String area_postcode;
                private String area_level;

                public String getNo() {
                    return no;
                }

                public void setNo(String no) {
                    this.no = no;
                }

                public String getParent_no() {
                    return parent_no;
                }

                public void setParent_no(String parent_no) {
                    this.parent_no = parent_no;
                }

                public String getArea_name() {
                    return area_name;
                }

                public void setArea_name(String area_name) {
                    this.area_name = area_name;
                }

                public String getArea_postcode() {
                    return area_postcode;
                }

                public void setArea_postcode(String area_postcode) {
                    this.area_postcode = area_postcode;
                }

                public String getArea_level() {
                    return area_level;
                }

                public void setArea_level(String area_level) {
                    this.area_level = area_level;
                }
            }
        }

        public class CoverImageInfoEntity {
            private int id;
            private String original;
            private String url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getOriginal() {
                return original;
            }

            public void setOriginal(String original) {
                this.original = original;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}