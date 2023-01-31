package com.nextgenpos.nextgenpos.ejb;

import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.common.ReportDto;
import com.nextgenpos.nextgenpos.entities.ItemSale;
import com.nextgenpos.nextgenpos.entities.Product;
import com.nextgenpos.nextgenpos.entities.Reports;
import com.nextgenpos.nextgenpos.entities.Sale;
import com.nextgenpos.nextgenpos.servlets.Products;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.mail.FetchProfile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class ReportsBean {
    @Inject
    ProductsBean productsBean;
    @Inject
    SalesBean salesBean;
    private static final Logger LOG = Logger.getLogger(Reports.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public void createSalesReportBetween(Date startDate, Date endDate){
    try{
        LOG.info("createSalesReportBetween " + startDate + " and " + endDate);

        List<Sale> sales= salesBean.findSalesBetween(startDate,endDate);
        String file = "These are the sales made between "+startDate.toString() + " and "+ endDate+ ": \n";


        for (Sale s:
             sales) {
            String salesInfo = " ID: " + s.getIdSale() + "; Date: " + s.getSaleDate() + "; Total: " + s.getTotal() + "; SellerID: " + s.getUser().getIdUser().toString() + "; Products: \n";
                    for (ItemSale itemSale :
                            s.getItemSales()) {
                        String items = " id:" + itemSale.getIdItemSale().toString() + "; Product:" + itemSale.getProduct().getProductName() + "; PricePerUnit"+ itemSale.getPricePerUnit().toString()+ "; Quantity:" + itemSale.getQuantity().toString() + '\n';
                        salesInfo = salesInfo +items.toString();
                    }


            file= file+ salesInfo.toString();
        }

        byte[] fileDataBytes = file.getBytes();
        Date today = new Date();
        Reports report = new Reports();
        report.setReportName("SalesReport");
        report.setFileContent(fileDataBytes);
        report.setDate(today);
        report.setReportFileType(".txt");
        entityManager.persist(report);
    }
    catch(Exception ex){
        throw new EJBException(ex);
    }}

    public void createStockReport(){
        try {
            LOG.info("createStockReport");
            List<ProductDto> products = productsBean.findAllProducts();
            String file = "This is the current stock:\n";
/*            products.forEach((p) -> {
                String productInfo = " ID: " + p.getIdProduct() + "; Product name: " + p.getProductName() + "; Quantity: " + p.getQuantity() + "; Provider: " + p.getProvider() + "; Price: " + p.getPrice() + "; \n";
                file.concat(productInfo.toString());
            });*/
            for (ProductDto p :
                    products) {
                String productInfo = " ID: " + p.getIdProduct() + "; Product name: " + p.getProductName() + "; Quantity: " + p.getQuantity() + "; Provider: " + p.getProvider() + "; Price: " + p.getPrice() + "; \n";
                file = file + productInfo.toString();
            }
            byte[] fileDataBytes = file.getBytes();
            Date today = new Date();
            Reports report = new Reports();
            report.setReportName("StockReport");
            report.setFileContent(fileDataBytes);
            report.setDate(today);
            report.setReportFileType(".txt");
            entityManager.persist(report);

        }
        catch(Exception ex){
            throw new EJBException(ex);
        }}


    public void createProductReport(ProductDto product){
        try {
            LOG.info("createProductReport");
            List<ItemSale> sales = salesBean.findProductSales(product.getIdProduct());
            String file = "These are the sales on the product with id:"+ product.getIdProduct() + "(" + product.getProductName() + ")" + "\n";


            for (ItemSale s:
                 sales) {
                String productSale = " ID: " + s.getIdItemSale().toString() + "; Sale id: " + s.getSale().getIdSale().toString() + "; Quantity: " + s.getQuantity() + "; PricePerUnit: " + s.getPricePerUnit() +" Date"+s.getSale().getSaleDate()  + "; Seller" + s.getSale().getUser().getIdUser().toString() + "; \n";
                file= file + productSale.toString();

            }
            byte[] fileDataBytes = file.getBytes();
            Date today = new Date();
            Reports report = new Reports();
            report.setReportName("ProductReport");
            report.setFileContent(fileDataBytes);
            report.setDate(today);
            report.setReportFileType(".txt");
            entityManager.persist(report);

        }
        catch(Exception ex){
            throw new EJBException(ex);
        }}

    public List<ReportDto> findAllStockReports(){
        try {
            LOG.info("findAllStockReports");
            TypedQuery<Reports> typedQuery = entityManager.createQuery("SELECT r FROM Reports r", Reports.class);
            List<Reports> reports = typedQuery.getResultList();
            List<ReportDto> reportDtos = new ArrayList<>();
            for (Reports r :
                    reports) {
                String data= new String(r.getFileContent(), StandardCharsets.UTF_8);
                String[] reportTextLines = data.split("\n");
                reportDtos.add( new ReportDto(r.getIdReport(),r.getReportName(),r.getReportFileType(),reportTextLines,r.getDate()));
            }
            return reportDtos;
        } catch (Exception ex){
            throw new EJBException(ex);
        }
    }
}


