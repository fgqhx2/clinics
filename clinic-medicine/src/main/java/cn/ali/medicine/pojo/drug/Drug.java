package cn.ali.medicine.pojo.drug;

import lombok.ToString;

import java.util.Date;
@ToString
public class Drug {

    private Integer id;//序号
    private String code;//编码
    private String barCode;//条形码
    private String name;//药品通用名
    private String pinyinCode;//拼音码
    private Integer drug_typeId;//药品分类
    private String spec;//药品规格
    private Integer dosage_formId;//剂型
    private Integer OTC;//OTC
    private Integer invoiceId;//发票项目
    private String wholesale;//批发号
    private Integer manufacturerId;//生产厂家
    private Integer status;//状态
    private Integer usageId;//用法序号
    private Integer a_single_dose;//单次用量
    private String aunit;//单次用量单位
    private Integer frequencyId;//频次序号
    private Integer days;//天数
    private Integer gross;//总量
    private Integer gross_unitId;//总量单位
    private float purchase_price;//采购金额
    private float retail_price;//零售金额
    private String goods;//货位号
    private Integer stock;//库存量
    private Date creation_time;//创建时间
    private Integer creator;//创建人


    private String drug_type;//药品分类名称
    private String dosage_form;//挤型名称
    private String invoice;//发票项目名称
    private String manufacturer;//生产厂家名称
    private String usages;//用法名称
    private String frequency;//频度名称
    private String gross_unit;//单位名称
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAunit() {
        return aunit;
    }

    public void setAunit(String aunit) {
        this.aunit = aunit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode;
    }

    public Integer getDrug_typeId() {
        return drug_typeId;
    }

    public void setDrug_typeId(Integer drug_typeId) {
        this.drug_typeId = drug_typeId;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getDosage_formId() {
        return dosage_formId;
    }

    public void setDosage_formId(Integer dosage_formId) {
        this.dosage_formId = dosage_formId;
    }

    public Integer getOTC() {
        return OTC;
    }

    public void setOTC(Integer OTC) {
        this.OTC = OTC;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getWholesale() {
        return wholesale;
    }

    public void setWholesale(String wholesale) {
        this.wholesale = wholesale;
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUsageId() {
        return usageId;
    }

    public void setUsageId(Integer usageId) {
        this.usageId = usageId;
    }

    public Integer getA_single_dose() {
        return a_single_dose;
    }

    public void setA_single_dose(Integer a_single_dose) {
        this.a_single_dose = a_single_dose;
    }

    public Integer getFrequencyId() {
        return frequencyId;
    }

    public void setFrequencyId(Integer frequencyId) {
        this.frequencyId = frequencyId;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getGross() {
        return gross;
    }

    public void setGross(Integer gross) {
        this.gross = gross;
    }

    public Integer getGross_unitId() {
        return gross_unitId;
    }

    public void setGross_unitId(Integer gross_unitId) {
        this.gross_unitId = gross_unitId;
    }

    public float getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(float purchase_price) {
        this.purchase_price = purchase_price;
    }

    public float getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(float retail_price) {
        this.retail_price = retail_price;
    }



    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }



    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getDrug_type() {
        return drug_type;
    }

    public void setDrug_type(String drug_type) {
        this.drug_type = drug_type;
    }

    public String getDosage_form() {
        return dosage_form;
    }

    public void setDosage_form(String dosage_form) {
        this.dosage_form = dosage_form;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getUsages() {
        return usages;
    }

    public void setUsages(String usages) {
        this.usages = usages;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getGross_unit() {
        return gross_unit;
    }

    public void setGross_unit(String gross_unit) {
        this.gross_unit = gross_unit;
    }
}
