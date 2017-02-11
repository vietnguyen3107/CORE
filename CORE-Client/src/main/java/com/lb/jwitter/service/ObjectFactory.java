
package com.lb.jwitter.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lb.jwitter.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindColumnTblDonViByCondition_QNAME = new QName("http://service.jwitter.lb.com/", "findColumnTbl_DonViByCondition");
    private final static QName _FindAllTblDonVi_QNAME = new QName("http://service.jwitter.lb.com/", "findAllTbl_DonVi");
    private final static QName _DeleteTblDonViResponse_QNAME = new QName("http://service.jwitter.lb.com/", "deleteTbl_DonViResponse");
    private final static QName _QueryHQLTblDonViResponse_QNAME = new QName("http://service.jwitter.lb.com/", "queryHQLTbl_DonViResponse");
    private final static QName _FindAllTblDonViResponse_QNAME = new QName("http://service.jwitter.lb.com/", "findAllTbl_DonViResponse");
    private final static QName _CountTblDonViByCondition_QNAME = new QName("http://service.jwitter.lb.com/", "countTbl_DonViByCondition");
    private final static QName _GetTblDonVi_QNAME = new QName("http://service.jwitter.lb.com/", "getTbl_DonVi");
    private final static QName _FindTblDonViByConditionResponse_QNAME = new QName("http://service.jwitter.lb.com/", "findTbl_DonViByConditionResponse");
    private final static QName _UpdateTblDonViResponse_QNAME = new QName("http://service.jwitter.lb.com/", "updateTbl_DonViResponse");
    private final static QName _FindColumnTblDonViByConditionResponse_QNAME = new QName("http://service.jwitter.lb.com/", "findColumnTbl_DonViByConditionResponse");
    private final static QName _CountTblDonViByConditionResponse_QNAME = new QName("http://service.jwitter.lb.com/", "countTbl_DonViByConditionResponse");
    private final static QName _CreateTblDonVi_QNAME = new QName("http://service.jwitter.lb.com/", "createTbl_DonVi");
    private final static QName _UpdateTblDonVi_QNAME = new QName("http://service.jwitter.lb.com/", "updateTbl_DonVi");
    private final static QName _DeleteTblDonVi_QNAME = new QName("http://service.jwitter.lb.com/", "deleteTbl_DonVi");
    private final static QName _FindTblDonViByCondition_QNAME = new QName("http://service.jwitter.lb.com/", "findTbl_DonViByCondition");
    private final static QName _GetTblDonViResponse_QNAME = new QName("http://service.jwitter.lb.com/", "getTbl_DonViResponse");
    private final static QName _QueryHQLTblDonVi_QNAME = new QName("http://service.jwitter.lb.com/", "queryHQLTbl_DonVi");
    private final static QName _DeleteListTblDonViResponse_QNAME = new QName("http://service.jwitter.lb.com/", "deleteListTbl_DonViResponse");
    private final static QName _DeleteListTblDonVi_QNAME = new QName("http://service.jwitter.lb.com/", "deleteListTbl_DonVi");
    private final static QName _CreateTblDonViResponse_QNAME = new QName("http://service.jwitter.lb.com/", "createTbl_DonViResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lb.jwitter.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConditionReport }
     * 
     */
    public ConditionReport createConditionReport() {
        return new ConditionReport();
    }

    /**
     * Create an instance of {@link QueryHQLTblDonVi }
     * 
     */
    public QueryHQLTblDonVi createQueryHQLTblDonVi() {
        return new QueryHQLTblDonVi();
    }

    /**
     * Create an instance of {@link DeleteListTblDonViResponse }
     * 
     */
    public DeleteListTblDonViResponse createDeleteListTblDonViResponse() {
        return new DeleteListTblDonViResponse();
    }

    /**
     * Create an instance of {@link CountTblDonViByConditionResponse }
     * 
     */
    public CountTblDonViByConditionResponse createCountTblDonViByConditionResponse() {
        return new CountTblDonViByConditionResponse();
    }

    /**
     * Create an instance of {@link UpdateTblDonViResponse }
     * 
     */
    public UpdateTblDonViResponse createUpdateTblDonViResponse() {
        return new UpdateTblDonViResponse();
    }

    /**
     * Create an instance of {@link DeleteTblDonViResponse }
     * 
     */
    public DeleteTblDonViResponse createDeleteTblDonViResponse() {
        return new DeleteTblDonViResponse();
    }

    /**
     * Create an instance of {@link FindAllTblDonVi }
     * 
     */
    public FindAllTblDonVi createFindAllTblDonVi() {
        return new FindAllTblDonVi();
    }

    /**
     * Create an instance of {@link GetTblDonVi }
     * 
     */
    public GetTblDonVi createGetTblDonVi() {
        return new GetTblDonVi();
    }

    /**
     * Create an instance of {@link TblDonVi }
     * 
     */
    public TblDonVi createTblDonVi() {
        return new TblDonVi();
    }

    /**
     * Create an instance of {@link DeleteListTblDonVi }
     * 
     */
    public DeleteListTblDonVi createDeleteListTblDonVi() {
        return new DeleteListTblDonVi();
    }

    /**
     * Create an instance of {@link QueryHQLTblDonViResponse }
     * 
     */
    public QueryHQLTblDonViResponse createQueryHQLTblDonViResponse() {
        return new QueryHQLTblDonViResponse();
    }

    /**
     * Create an instance of {@link CountTblDonViByCondition }
     * 
     */
    public CountTblDonViByCondition createCountTblDonViByCondition() {
        return new CountTblDonViByCondition();
    }

    /**
     * Create an instance of {@link FindColumnTblDonViByCondition }
     * 
     */
    public FindColumnTblDonViByCondition createFindColumnTblDonViByCondition() {
        return new FindColumnTblDonViByCondition();
    }

    /**
     * Create an instance of {@link DeleteTblDonVi }
     * 
     */
    public DeleteTblDonVi createDeleteTblDonVi() {
        return new DeleteTblDonVi();
    }

    /**
     * Create an instance of {@link FindTblDonViByCondition }
     * 
     */
    public FindTblDonViByCondition createFindTblDonViByCondition() {
        return new FindTblDonViByCondition();
    }

    /**
     * Create an instance of {@link FindColumnTblDonViByConditionResponse }
     * 
     */
    public FindColumnTblDonViByConditionResponse createFindColumnTblDonViByConditionResponse() {
        return new FindColumnTblDonViByConditionResponse();
    }

    /**
     * Create an instance of {@link GetTblDonViResponse }
     * 
     */
    public GetTblDonViResponse createGetTblDonViResponse() {
        return new GetTblDonViResponse();
    }

    /**
     * Create an instance of {@link FindTblDonViByConditionResponse }
     * 
     */
    public FindTblDonViByConditionResponse createFindTblDonViByConditionResponse() {
        return new FindTblDonViByConditionResponse();
    }

    /**
     * Create an instance of {@link FindAllTblDonViResponse }
     * 
     */
    public FindAllTblDonViResponse createFindAllTblDonViResponse() {
        return new FindAllTblDonViResponse();
    }

    /**
     * Create an instance of {@link CreateTblDonViResponse }
     * 
     */
    public CreateTblDonViResponse createCreateTblDonViResponse() {
        return new CreateTblDonViResponse();
    }

    /**
     * Create an instance of {@link UpdateTblDonVi }
     * 
     */
    public UpdateTblDonVi createUpdateTblDonVi() {
        return new UpdateTblDonVi();
    }

    /**
     * Create an instance of {@link CreateTblDonVi }
     * 
     */
    public CreateTblDonVi createCreateTblDonVi() {
        return new CreateTblDonVi();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindColumnTblDonViByCondition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "findColumnTbl_DonViByCondition")
    public JAXBElement<FindColumnTblDonViByCondition> createFindColumnTblDonViByCondition(FindColumnTblDonViByCondition value) {
        return new JAXBElement<FindColumnTblDonViByCondition>(_FindColumnTblDonViByCondition_QNAME, FindColumnTblDonViByCondition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllTblDonVi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "findAllTbl_DonVi")
    public JAXBElement<FindAllTblDonVi> createFindAllTblDonVi(FindAllTblDonVi value) {
        return new JAXBElement<FindAllTblDonVi>(_FindAllTblDonVi_QNAME, FindAllTblDonVi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTblDonViResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "deleteTbl_DonViResponse")
    public JAXBElement<DeleteTblDonViResponse> createDeleteTblDonViResponse(DeleteTblDonViResponse value) {
        return new JAXBElement<DeleteTblDonViResponse>(_DeleteTblDonViResponse_QNAME, DeleteTblDonViResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryHQLTblDonViResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "queryHQLTbl_DonViResponse")
    public JAXBElement<QueryHQLTblDonViResponse> createQueryHQLTblDonViResponse(QueryHQLTblDonViResponse value) {
        return new JAXBElement<QueryHQLTblDonViResponse>(_QueryHQLTblDonViResponse_QNAME, QueryHQLTblDonViResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllTblDonViResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "findAllTbl_DonViResponse")
    public JAXBElement<FindAllTblDonViResponse> createFindAllTblDonViResponse(FindAllTblDonViResponse value) {
        return new JAXBElement<FindAllTblDonViResponse>(_FindAllTblDonViResponse_QNAME, FindAllTblDonViResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountTblDonViByCondition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "countTbl_DonViByCondition")
    public JAXBElement<CountTblDonViByCondition> createCountTblDonViByCondition(CountTblDonViByCondition value) {
        return new JAXBElement<CountTblDonViByCondition>(_CountTblDonViByCondition_QNAME, CountTblDonViByCondition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTblDonVi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "getTbl_DonVi")
    public JAXBElement<GetTblDonVi> createGetTblDonVi(GetTblDonVi value) {
        return new JAXBElement<GetTblDonVi>(_GetTblDonVi_QNAME, GetTblDonVi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindTblDonViByConditionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "findTbl_DonViByConditionResponse")
    public JAXBElement<FindTblDonViByConditionResponse> createFindTblDonViByConditionResponse(FindTblDonViByConditionResponse value) {
        return new JAXBElement<FindTblDonViByConditionResponse>(_FindTblDonViByConditionResponse_QNAME, FindTblDonViByConditionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTblDonViResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "updateTbl_DonViResponse")
    public JAXBElement<UpdateTblDonViResponse> createUpdateTblDonViResponse(UpdateTblDonViResponse value) {
        return new JAXBElement<UpdateTblDonViResponse>(_UpdateTblDonViResponse_QNAME, UpdateTblDonViResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindColumnTblDonViByConditionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "findColumnTbl_DonViByConditionResponse")
    public JAXBElement<FindColumnTblDonViByConditionResponse> createFindColumnTblDonViByConditionResponse(FindColumnTblDonViByConditionResponse value) {
        return new JAXBElement<FindColumnTblDonViByConditionResponse>(_FindColumnTblDonViByConditionResponse_QNAME, FindColumnTblDonViByConditionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountTblDonViByConditionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "countTbl_DonViByConditionResponse")
    public JAXBElement<CountTblDonViByConditionResponse> createCountTblDonViByConditionResponse(CountTblDonViByConditionResponse value) {
        return new JAXBElement<CountTblDonViByConditionResponse>(_CountTblDonViByConditionResponse_QNAME, CountTblDonViByConditionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTblDonVi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "createTbl_DonVi")
    public JAXBElement<CreateTblDonVi> createCreateTblDonVi(CreateTblDonVi value) {
        return new JAXBElement<CreateTblDonVi>(_CreateTblDonVi_QNAME, CreateTblDonVi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTblDonVi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "updateTbl_DonVi")
    public JAXBElement<UpdateTblDonVi> createUpdateTblDonVi(UpdateTblDonVi value) {
        return new JAXBElement<UpdateTblDonVi>(_UpdateTblDonVi_QNAME, UpdateTblDonVi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTblDonVi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "deleteTbl_DonVi")
    public JAXBElement<DeleteTblDonVi> createDeleteTblDonVi(DeleteTblDonVi value) {
        return new JAXBElement<DeleteTblDonVi>(_DeleteTblDonVi_QNAME, DeleteTblDonVi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindTblDonViByCondition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "findTbl_DonViByCondition")
    public JAXBElement<FindTblDonViByCondition> createFindTblDonViByCondition(FindTblDonViByCondition value) {
        return new JAXBElement<FindTblDonViByCondition>(_FindTblDonViByCondition_QNAME, FindTblDonViByCondition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTblDonViResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "getTbl_DonViResponse")
    public JAXBElement<GetTblDonViResponse> createGetTblDonViResponse(GetTblDonViResponse value) {
        return new JAXBElement<GetTblDonViResponse>(_GetTblDonViResponse_QNAME, GetTblDonViResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryHQLTblDonVi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "queryHQLTbl_DonVi")
    public JAXBElement<QueryHQLTblDonVi> createQueryHQLTblDonVi(QueryHQLTblDonVi value) {
        return new JAXBElement<QueryHQLTblDonVi>(_QueryHQLTblDonVi_QNAME, QueryHQLTblDonVi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteListTblDonViResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "deleteListTbl_DonViResponse")
    public JAXBElement<DeleteListTblDonViResponse> createDeleteListTblDonViResponse(DeleteListTblDonViResponse value) {
        return new JAXBElement<DeleteListTblDonViResponse>(_DeleteListTblDonViResponse_QNAME, DeleteListTblDonViResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteListTblDonVi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "deleteListTbl_DonVi")
    public JAXBElement<DeleteListTblDonVi> createDeleteListTblDonVi(DeleteListTblDonVi value) {
        return new JAXBElement<DeleteListTblDonVi>(_DeleteListTblDonVi_QNAME, DeleteListTblDonVi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTblDonViResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jwitter.lb.com/", name = "createTbl_DonViResponse")
    public JAXBElement<CreateTblDonViResponse> createCreateTblDonViResponse(CreateTblDonViResponse value) {
        return new JAXBElement<CreateTblDonViResponse>(_CreateTblDonViResponse_QNAME, CreateTblDonViResponse.class, null, value);
    }

}
