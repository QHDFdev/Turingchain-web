
package com.tulingchain.soap.schema.read;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tulingchain.soap.schema package. 
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

    private final static QName _CreateTransaction_QNAME = new QName("com.examples.rpc", "create_transaction");
    private final static QName _GetLastBlockResponse_QNAME = new QName("com.examples.rpc", "get_last_blockResponse");
    private final static QName _WhoItem_QNAME = new QName("soap_rpc.models", "WhoItem");
    private final static QName _GetTxByIdResponse_QNAME = new QName("com.examples.rpc", "get_tx_by_idResponse");
    private final static QName _GetBlockByTxIdResponse_QNAME = new QName("com.examples.rpc", "get_block_by_tx_idResponse");
    private final static QName _StringArray_QNAME = new QName("com.examples.rpc", "stringArray");
    private final static QName _TransferResult_QNAME = new QName("soap_rpc.models", "TransferResult");
    private final static QName _Block_QNAME = new QName("soap_rpc.models", "Block");
    private final static QName _GetBlockByHeightResponse_QNAME = new QName("com.examples.rpc", "get_block_by_heightResponse");
    private final static QName _Vote_QNAME = new QName("soap_rpc.models", "Vote");
    private final static QName _SubFulfillmentArray_QNAME = new QName("soap_rpc.models", "SubFulfillmentArray");
    private final static QName _GetTxsByBlockAddr_QNAME = new QName("com.examples.rpc", "get_txs_by_block_addr");
    private final static QName _TransactionArray_QNAME = new QName("soap_rpc.models", "TransactionArray");
    private final static QName _GetBlockHeightByTxId_QNAME = new QName("com.examples.rpc", "get_block_height_by_tx_id");
    private final static QName _ConditionDetailDetail_QNAME = new QName("soap_rpc.models", "ConditionDetailDetail");
    private final static QName _TransferTransactionResponse_QNAME = new QName("com.examples.rpc", "transfer_transactionResponse");
    private final static QName _VoteArray_QNAME = new QName("soap_rpc.models", "VoteArray");
    private final static QName _GetTxById_QNAME = new QName("com.examples.rpc", "get_tx_by_id");
    private final static QName _TraceTransactions_QNAME = new QName("com.examples.rpc", "trace_transactions");
    private final static QName _Payload_QNAME = new QName("soap_rpc.models", "Payload");
    private final static QName _ConditionDetail_QNAME = new QName("soap_rpc.models", "ConditionDetail");
    private final static QName _ConditionArray_QNAME = new QName("soap_rpc.models", "ConditionArray");
    private final static QName _Transaction_QNAME = new QName("soap_rpc.models", "Transaction");
    private final static QName _Input_QNAME = new QName("soap_rpc.models", "Input");
    private final static QName _LastTx_QNAME = new QName("soap_rpc.models", "LastTx");
    private final static QName _TxPair_QNAME = new QName("soap_rpc.models", "TxPair");
    private final static QName _GetLastTx_QNAME = new QName("com.examples.rpc", "get_last_tx");
    private final static QName _TraceTransactionsResponse_QNAME = new QName("com.examples.rpc", "trace_transactionsResponse");
    private final static QName _Fulfillment_QNAME = new QName("soap_rpc.models", "Fulfillment");
    private final static QName _Condition_QNAME = new QName("soap_rpc.models", "Condition");
    private final static QName _KeyPair_QNAME = new QName("soap_rpc.models", "KeyPair");
    private final static QName _GetBlockByHeight_QNAME = new QName("com.examples.rpc", "get_block_by_height");
    private final static QName _VoteDetail_QNAME = new QName("soap_rpc.models", "VoteDetail");
    private final static QName _SubFulfillment_QNAME = new QName("soap_rpc.models", "SubFulfillment");
    private final static QName _Who_QNAME = new QName("soap_rpc.models", "Who");
    private final static QName _GetBlockByTxId_QNAME = new QName("com.examples.rpc", "get_block_by_tx_id");
    private final static QName _GetBlockHeightByTxIdResponse_QNAME = new QName("com.examples.rpc", "get_block_height_by_tx_idResponse");
    private final static QName _FulfillmentArray_QNAME = new QName("soap_rpc.models", "FulfillmentArray");
    private final static QName _TransactionDetail_QNAME = new QName("soap_rpc.models", "TransactionDetail");
    private final static QName _Where_QNAME = new QName("soap_rpc.models", "Where");
    private final static QName _GetLastBlock_QNAME = new QName("com.examples.rpc", "get_last_block");
    private final static QName _Data_QNAME = new QName("soap_rpc.models", "Data");
    private final static QName _When_QNAME = new QName("soap_rpc.models", "When");
    private final static QName _WhereItem_QNAME = new QName("soap_rpc.models", "WhereItem");
    private final static QName _GetTxsByBlockAddrResponse_QNAME = new QName("com.examples.rpc", "get_txs_by_block_addrResponse");
    private final static QName _BigBlock_QNAME = new QName("soap_rpc.models", "BigBlock");
    private final static QName _Thing_QNAME = new QName("soap_rpc.models", "Thing");
    private final static QName _TransferTransaction_QNAME = new QName("com.examples.rpc", "transfer_transaction");
    private final static QName _CreateTransactionResponse_QNAME = new QName("com.examples.rpc", "create_transactionResponse");
    private final static QName _GetLastTxResponse_QNAME = new QName("com.examples.rpc", "get_last_txResponse");
    private final static QName _LastBlock_QNAME = new QName("soap_rpc.models", "LastBlock");
    private final static QName _GetKeyPair_QNAME = new QName("com.examples.rpc", "get_key_pair");
    private final static QName _GetKeyPairResponse_QNAME = new QName("com.examples.rpc", "get_key_pairResponse");
    private final static QName _GetTxByIdId_QNAME = new QName("com.examples.rpc", "id");
    private final static QName _TransferTransactionResponseTransferTransactionResult_QNAME = new QName("com.examples.rpc", "transfer_transactionResult");
    private final static QName _GetBlockByTxIdTxId_QNAME = new QName("com.examples.rpc", "tx_id");
    private final static QName _LastBlockNodePubkey_QNAME = new QName("soap_rpc.models", "node_pubkey");
    private final static QName _LastBlockHeight_QNAME = new QName("soap_rpc.models", "height");
    private final static QName _LastBlockTimestamp_QNAME = new QName("soap_rpc.models", "timestamp");
    private final static QName _LastBlockTxIds_QNAME = new QName("soap_rpc.models", "tx_ids");
    private final static QName _VoteDetailInvalidReason_QNAME = new QName("soap_rpc.models", "invalid_reason");
    private final static QName _VoteDetailPreviousBlock_QNAME = new QName("soap_rpc.models", "previous_block");
    private final static QName _VoteDetailVotingForBlock_QNAME = new QName("soap_rpc.models", "voting_for_block");
    private final static QName _VoteDetailIsBlockValid_QNAME = new QName("soap_rpc.models", "is_block_valid");
    private final static QName _ThingOriginPlace_QNAME = new QName("soap_rpc.models", "origin_place");
    private final static QName _ThingThingOrderBatch_QNAME = new QName("soap_rpc.models", "thing_order_batch");
    private final static QName _ThingThingOrderQuantity_QNAME = new QName("soap_rpc.models", "thing_order_quantity");
    private final static QName _ThingThingId_QNAME = new QName("soap_rpc.models", "thing_id");
    private final static QName _ThingThingTypeId_QNAME = new QName("soap_rpc.models", "thing_type_id");
    private final static QName _ThingPrice_QNAME = new QName("soap_rpc.models", "price");
    private final static QName _ThingThingName_QNAME = new QName("soap_rpc.models", "thing_name");
    private final static QName _ThingThingTypeName_QNAME = new QName("soap_rpc.models", "thing_type_name");
    private final static QName _GetKeyPairResponseGetKeyPairResult_QNAME = new QName("com.examples.rpc", "get_key_pairResult");
    private final static QName _GetBlockHeightByTxIdResponseGetBlockHeightByTxIdResult_QNAME = new QName("com.examples.rpc", "get_block_height_by_tx_idResult");
    private final static QName _TransferTransactionTxOriginatorPrivateKey_QNAME = new QName("com.examples.rpc", "tx_originator_private_key");
    private final static QName _TransferTransactionTxRecipientPublicKey_QNAME = new QName("com.examples.rpc", "tx_recipient_public_key");
    private final static QName _TransferTransactionTxOriginatorPublicKey_QNAME = new QName("com.examples.rpc", "tx_originator_public_key");
    private final static QName _TransferTransactionWhen_QNAME = new QName("com.examples.rpc", "when");
    private final static QName _TransferTransactionThing_QNAME = new QName("com.examples.rpc", "thing");
    private final static QName _TransferTransactionWho_QNAME = new QName("com.examples.rpc", "who");
    private final static QName _TransferTransactionWhere_QNAME = new QName("com.examples.rpc", "where");
    private final static QName _GetTxsByBlockAddrAddr_QNAME = new QName("com.examples.rpc", "addr");
    private final static QName _GetTxByIdResponseGetTxByIdResult_QNAME = new QName("com.examples.rpc", "get_tx_by_idResult");
    private final static QName _VoteSignature_QNAME = new QName("soap_rpc.models", "signature");
    private final static QName _VoteVote_QNAME = new QName("soap_rpc.models", "vote");
    private final static QName _GetLastTxResponseGetLastTxResult_QNAME = new QName("com.examples.rpc", "get_last_txResult");
    private final static QName _ConditionCid_QNAME = new QName("soap_rpc.models", "cid");
    private final static QName _ConditionNewOwners_QNAME = new QName("soap_rpc.models", "new_owners");
    private final static QName _ConditionCondition_QNAME = new QName("soap_rpc.models", "condition");
    private final static QName _ConditionDetailDetailTypeId_QNAME = new QName("soap_rpc.models", "type_id");
    private final static QName _ConditionDetailDetailThreshold_QNAME = new QName("soap_rpc.models", "threshold");
    private final static QName _ConditionDetailDetailType_QNAME = new QName("soap_rpc.models", "type");
    private final static QName _ConditionDetailDetailPublicKey_QNAME = new QName("soap_rpc.models", "public_key");
    private final static QName _ConditionDetailDetailBitmask_QNAME = new QName("soap_rpc.models", "bitmask");
    private final static QName _ConditionDetailDetailSubfulfillments_QNAME = new QName("soap_rpc.models", "subfulfillments");
    private final static QName _WhenMakeDate_QNAME = new QName("soap_rpc.models", "make_date");
    private final static QName _WhenReceiveDate_QNAME = new QName("soap_rpc.models", "receive_date");
    private final static QName _WhenSendDate_QNAME = new QName("soap_rpc.models", "send_date");
    private final static QName _WhenExpireDate_QNAME = new QName("soap_rpc.models", "expire_date");
    private final static QName _FulfillmentCurrentOwners_QNAME = new QName("soap_rpc.models", "current_owners");
    private final static QName _FulfillmentFulfillment_QNAME = new QName("soap_rpc.models", "fulfillment");
    private final static QName _FulfillmentInput_QNAME = new QName("soap_rpc.models", "input");
    private final static QName _FulfillmentFid_QNAME = new QName("soap_rpc.models", "fid");
    private final static QName _BlockVoters_QNAME = new QName("soap_rpc.models", "voters");
    private final static QName _BlockTransactions_QNAME = new QName("soap_rpc.models", "transactions");
    private final static QName _DataUuid_QNAME = new QName("soap_rpc.models", "uuid");
    private final static QName _DataPayload_QNAME = new QName("soap_rpc.models", "payload");
    private final static QName _GetBlockByTxIdResponseGetBlockByTxIdResult_QNAME = new QName("com.examples.rpc", "get_block_by_tx_idResult");
    private final static QName _WhereGoto_QNAME = new QName("soap_rpc.models", "goto");
    private final static QName _WhereOriginal_QNAME = new QName("soap_rpc.models", "original");
    private final static QName _SubFulfillmentWeight_QNAME = new QName("soap_rpc.models", "weight");
    private final static QName _TransactionVersion_QNAME = new QName("soap_rpc.models", "version");
    private final static QName _TransactionTransaction_QNAME = new QName("soap_rpc.models", "transaction");
    private final static QName _TransactionId_QNAME = new QName("soap_rpc.models", "id");
    private final static QName _ConditionDetailUri_QNAME = new QName("soap_rpc.models", "uri");
    private final static QName _ConditionDetailDetails_QNAME = new QName("soap_rpc.models", "details");
    private final static QName _GetTxsByBlockAddrResponseGetTxsByBlockAddrResult_QNAME = new QName("com.examples.rpc", "get_txs_by_block_addrResult");
    private final static QName _TraceTransactionsPublicKey_QNAME = new QName("com.examples.rpc", "public_key");
    private final static QName _TransferResultNewKeyPair_QNAME = new QName("soap_rpc.models", "new_key_pair");
    private final static QName _TransferResultMessage_QNAME = new QName("soap_rpc.models", "message");
    private final static QName _TransferResultTxs_QNAME = new QName("soap_rpc.models", "txs");
    private final static QName _TxPairTransferId_QNAME = new QName("soap_rpc.models", "transfer_id");
    private final static QName _TxPairCreateId_QNAME = new QName("soap_rpc.models", "create_id");
    private final static QName _InputTxid_QNAME = new QName("soap_rpc.models", "txid");
    private final static QName _WhoItemUserId_QNAME = new QName("soap_rpc.models", "user_id");
    private final static QName _WhoItemUCompanyId_QNAME = new QName("soap_rpc.models", "u_company_id");
    private final static QName _WhoItemCompanyName_QNAME = new QName("soap_rpc.models", "company_name");
    private final static QName _WhoItemUserType_QNAME = new QName("soap_rpc.models", "user_type");
    private final static QName _WhoItemCompanyId_QNAME = new QName("soap_rpc.models", "company_id");
    private final static QName _WhoItemUserName_QNAME = new QName("soap_rpc.models", "user_name");
    private final static QName _WhereItemNation_QNAME = new QName("soap_rpc.models", "nation");
    private final static QName _WhereItemPlace_QNAME = new QName("soap_rpc.models", "place");
    private final static QName _WhereItemRegionId_QNAME = new QName("soap_rpc.models", "region_id");
    private final static QName _WhereItemRegion_QNAME = new QName("soap_rpc.models", "region");
    private final static QName _GetBlockByHeightHeight_QNAME = new QName("com.examples.rpc", "height");
    private final static QName _CreateTransactionResponseCreateTransactionResult_QNAME = new QName("com.examples.rpc", "create_transactionResult");
    private final static QName _GetLastBlockResponseGetLastBlockResult_QNAME = new QName("com.examples.rpc", "get_last_blockResult");
    private final static QName _PayloadThing_QNAME = new QName("soap_rpc.models", "thing");
    private final static QName _PayloadWho_QNAME = new QName("soap_rpc.models", "who");
    private final static QName _PayloadWhere_QNAME = new QName("soap_rpc.models", "where");
    private final static QName _PayloadPreviousProcessTxId_QNAME = new QName("soap_rpc.models", "previous_process_tx_id");
    private final static QName _PayloadWhen_QNAME = new QName("soap_rpc.models", "when");
    private final static QName _GetBlockByHeightResponseGetBlockByHeightResult_QNAME = new QName("com.examples.rpc", "get_block_by_heightResult");
    private final static QName _TraceTransactionsResponseTraceTransactionsResult_QNAME = new QName("com.examples.rpc", "trace_transactionsResult");
    private final static QName _LastTxTxRecipient_QNAME = new QName("soap_rpc.models", "tx_recipient");
    private final static QName _LastTxTxId_QNAME = new QName("soap_rpc.models", "tx_id");
    private final static QName _LastTxTxOriginator_QNAME = new QName("soap_rpc.models", "tx_originator");
    private final static QName _BigBlockBlockNumber_QNAME = new QName("soap_rpc.models", "block_number");
    private final static QName _BigBlockVotes_QNAME = new QName("soap_rpc.models", "votes");
    private final static QName _BigBlockBlock_QNAME = new QName("soap_rpc.models", "block");
    private final static QName _TransactionDetailData_QNAME = new QName("soap_rpc.models", "data");
    private final static QName _TransactionDetailConditions_QNAME = new QName("soap_rpc.models", "conditions");
    private final static QName _TransactionDetailOperation_QNAME = new QName("soap_rpc.models", "operation");
    private final static QName _TransactionDetailFulfillments_QNAME = new QName("soap_rpc.models", "fulfillments");
    private final static QName _KeyPairPrivateKey_QNAME = new QName("soap_rpc.models", "private_key");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tulingchain.soap.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransferResult }
     * 
     */
    public TransferResult createTransferResult() {
        return new TransferResult();
    }

    /**
     * Create an instance of {@link Condition }
     * 
     */
    public Condition createCondition() {
        return new Condition();
    }

    /**
     * Create an instance of {@link KeyPair }
     * 
     */
    public KeyPair createKeyPair() {
        return new KeyPair();
    }

    /**
     * Create an instance of {@link WhoItem }
     * 
     */
    public WhoItem createWhoItem() {
        return new WhoItem();
    }

    /**
     * Create an instance of {@link Where }
     * 
     */
    public Where createWhere() {
        return new Where();
    }

    /**
     * Create an instance of {@link Data }
     * 
     */
    public Data createData() {
        return new Data();
    }

    /**
     * Create an instance of {@link FulfillmentArray }
     * 
     */
    public FulfillmentArray createFulfillmentArray() {
        return new FulfillmentArray();
    }

    /**
     * Create an instance of {@link TransactionDetail }
     * 
     */
    public TransactionDetail createTransactionDetail() {
        return new TransactionDetail();
    }

    /**
     * Create an instance of {@link SubFulfillment }
     * 
     */
    public SubFulfillment createSubFulfillment() {
        return new SubFulfillment();
    }

    /**
     * Create an instance of {@link Who }
     * 
     */
    public Who createWho() {
        return new Who();
    }

    /**
     * Create an instance of {@link Vote }
     * 
     */
    public Vote createVote() {
        return new Vote();
    }

    /**
     * Create an instance of {@link SubFulfillmentArray }
     * 
     */
    public SubFulfillmentArray createSubFulfillmentArray() {
        return new SubFulfillmentArray();
    }

    /**
     * Create an instance of {@link VoteDetail }
     * 
     */
    public VoteDetail createVoteDetail() {
        return new VoteDetail();
    }

    /**
     * Create an instance of {@link Block }
     * 
     */
    public Block createBlock() {
        return new Block();
    }

    /**
     * Create an instance of {@link Thing }
     * 
     */
    public Thing createThing() {
        return new Thing();
    }

    /**
     * Create an instance of {@link Input }
     * 
     */
    public Input createInput() {
        return new Input();
    }

    /**
     * Create an instance of {@link ConditionArray }
     * 
     */
    public ConditionArray createConditionArray() {
        return new ConditionArray();
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link BigBlock }
     * 
     */
    public BigBlock createBigBlock() {
        return new BigBlock();
    }

    /**
     * Create an instance of {@link Payload }
     * 
     */
    public Payload createPayload() {
        return new Payload();
    }

    /**
     * Create an instance of {@link ConditionDetail }
     * 
     */
    public ConditionDetail createConditionDetail() {
        return new ConditionDetail();
    }

    /**
     * Create an instance of {@link VoteArray }
     * 
     */
    public VoteArray createVoteArray() {
        return new VoteArray();
    }

    /**
     * Create an instance of {@link ConditionDetailDetail }
     * 
     */
    public ConditionDetailDetail createConditionDetailDetail() {
        return new ConditionDetailDetail();
    }

    /**
     * Create an instance of {@link When }
     * 
     */
    public When createWhen() {
        return new When();
    }

    /**
     * Create an instance of {@link WhereItem }
     * 
     */
    public WhereItem createWhereItem() {
        return new WhereItem();
    }

    /**
     * Create an instance of {@link TransactionArray }
     * 
     */
    public TransactionArray createTransactionArray() {
        return new TransactionArray();
    }

    /**
     * Create an instance of {@link Fulfillment }
     * 
     */
    public Fulfillment createFulfillment() {
        return new Fulfillment();
    }

    /**
     * Create an instance of {@link TxPair }
     * 
     */
    public TxPair createTxPair() {
        return new TxPair();
    }

    /**
     * Create an instance of {@link LastBlock }
     * 
     */
    public LastBlock createLastBlock() {
        return new LastBlock();
    }

    /**
     * Create an instance of {@link LastTx }
     * 
     */
    public LastTx createLastTx() {
        return new LastTx();
    }

    /**
     * Create an instance of {@link GetLastBlockResponse }
     * 
     */
    public GetLastBlockResponse createGetLastBlockResponse() {
        return new GetLastBlockResponse();
    }

    /**
     * Create an instance of {@link CreateTransaction }
     * 
     */
    public CreateTransaction createCreateTransaction() {
        return new CreateTransaction();
    }

    /**
     * Create an instance of {@link GetBlockHeightByTxId }
     * 
     */
    public GetBlockHeightByTxId createGetBlockHeightByTxId() {
        return new GetBlockHeightByTxId();
    }

    /**
     * Create an instance of {@link GetTxByIdResponse }
     * 
     */
    public GetTxByIdResponse createGetTxByIdResponse() {
        return new GetTxByIdResponse();
    }

    /**
     * Create an instance of {@link TransferTransactionResponse }
     * 
     */
    public TransferTransactionResponse createTransferTransactionResponse() {
        return new TransferTransactionResponse();
    }

    /**
     * Create an instance of {@link StringArray }
     * 
     */
    public StringArray createStringArray() {
        return new StringArray();
    }

    /**
     * Create an instance of {@link GetBlockByTxIdResponse }
     * 
     */
    public GetBlockByTxIdResponse createGetBlockByTxIdResponse() {
        return new GetBlockByTxIdResponse();
    }

    /**
     * Create an instance of {@link TraceTransactions }
     * 
     */
    public TraceTransactions createTraceTransactions() {
        return new TraceTransactions();
    }

    /**
     * Create an instance of {@link GetTxById }
     * 
     */
    public GetTxById createGetTxById() {
        return new GetTxById();
    }

    /**
     * Create an instance of {@link GetTxsByBlockAddrResponse }
     * 
     */
    public GetTxsByBlockAddrResponse createGetTxsByBlockAddrResponse() {
        return new GetTxsByBlockAddrResponse();
    }

    /**
     * Create an instance of {@link GetBlockByHeight }
     * 
     */
    public GetBlockByHeight createGetBlockByHeight() {
        return new GetBlockByHeight();
    }

    /**
     * Create an instance of {@link GetBlockByHeightResponse }
     * 
     */
    public GetBlockByHeightResponse createGetBlockByHeightResponse() {
        return new GetBlockByHeightResponse();
    }

    /**
     * Create an instance of {@link TransferTransaction }
     * 
     */
    public TransferTransaction createTransferTransaction() {
        return new TransferTransaction();
    }

    /**
     * Create an instance of {@link CreateTransactionResponse }
     * 
     */
    public CreateTransactionResponse createCreateTransactionResponse() {
        return new CreateTransactionResponse();
    }

    /**
     * Create an instance of {@link GetTxsByBlockAddr }
     * 
     */
    public GetTxsByBlockAddr createGetTxsByBlockAddr() {
        return new GetTxsByBlockAddr();
    }

    /**
     * Create an instance of {@link GetKeyPair }
     * 
     */
    public GetKeyPair createGetKeyPair() {
        return new GetKeyPair();
    }

    /**
     * Create an instance of {@link GetBlockByTxId }
     * 
     */
    public GetBlockByTxId createGetBlockByTxId() {
        return new GetBlockByTxId();
    }

    /**
     * Create an instance of {@link TraceTransactionsResponse }
     * 
     */
    public TraceTransactionsResponse createTraceTransactionsResponse() {
        return new TraceTransactionsResponse();
    }

    /**
     * Create an instance of {@link GetLastTx }
     * 
     */
    public GetLastTx createGetLastTx() {
        return new GetLastTx();
    }

    /**
     * Create an instance of {@link GetLastTxResponse }
     * 
     */
    public GetLastTxResponse createGetLastTxResponse() {
        return new GetLastTxResponse();
    }

    /**
     * Create an instance of {@link GetKeyPairResponse }
     * 
     */
    public GetKeyPairResponse createGetKeyPairResponse() {
        return new GetKeyPairResponse();
    }

    /**
     * Create an instance of {@link GetLastBlock }
     * 
     */
    public GetLastBlock createGetLastBlock() {
        return new GetLastBlock();
    }

    /**
     * Create an instance of {@link GetBlockHeightByTxIdResponse }
     * 
     */
    public GetBlockHeightByTxIdResponse createGetBlockHeightByTxIdResponse() {
        return new GetBlockHeightByTxIdResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTransaction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "create_transaction")
    public JAXBElement<CreateTransaction> createCreateTransaction(CreateTransaction value) {
        return new JAXBElement<CreateTransaction>(_CreateTransaction_QNAME, CreateTransaction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastBlockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_last_blockResponse")
    public JAXBElement<GetLastBlockResponse> createGetLastBlockResponse(GetLastBlockResponse value) {
        return new JAXBElement<GetLastBlockResponse>(_GetLastBlockResponse_QNAME, GetLastBlockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WhoItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "WhoItem")
    public JAXBElement<WhoItem> createWhoItem(WhoItem value) {
        return new JAXBElement<WhoItem>(_WhoItem_QNAME, WhoItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTxByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_tx_by_idResponse")
    public JAXBElement<GetTxByIdResponse> createGetTxByIdResponse(GetTxByIdResponse value) {
        return new JAXBElement<GetTxByIdResponse>(_GetTxByIdResponse_QNAME, GetTxByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBlockByTxIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_block_by_tx_idResponse")
    public JAXBElement<GetBlockByTxIdResponse> createGetBlockByTxIdResponse(GetBlockByTxIdResponse value) {
        return new JAXBElement<GetBlockByTxIdResponse>(_GetBlockByTxIdResponse_QNAME, GetBlockByTxIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "stringArray")
    public JAXBElement<StringArray> createStringArray(StringArray value) {
        return new JAXBElement<StringArray>(_StringArray_QNAME, StringArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "TransferResult")
    public JAXBElement<TransferResult> createTransferResult(TransferResult value) {
        return new JAXBElement<TransferResult>(_TransferResult_QNAME, TransferResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Block }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "Block")
    public JAXBElement<Block> createBlock(Block value) {
        return new JAXBElement<Block>(_Block_QNAME, Block.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBlockByHeightResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_block_by_heightResponse")
    public JAXBElement<GetBlockByHeightResponse> createGetBlockByHeightResponse(GetBlockByHeightResponse value) {
        return new JAXBElement<GetBlockByHeightResponse>(_GetBlockByHeightResponse_QNAME, GetBlockByHeightResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Vote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "Vote")
    public JAXBElement<Vote> createVote(Vote value) {
        return new JAXBElement<Vote>(_Vote_QNAME, Vote.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubFulfillmentArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "SubFulfillmentArray")
    public JAXBElement<SubFulfillmentArray> createSubFulfillmentArray(SubFulfillmentArray value) {
        return new JAXBElement<SubFulfillmentArray>(_SubFulfillmentArray_QNAME, SubFulfillmentArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTxsByBlockAddr }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_txs_by_block_addr")
    public JAXBElement<GetTxsByBlockAddr> createGetTxsByBlockAddr(GetTxsByBlockAddr value) {
        return new JAXBElement<GetTxsByBlockAddr>(_GetTxsByBlockAddr_QNAME, GetTxsByBlockAddr.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "TransactionArray")
    public JAXBElement<TransactionArray> createTransactionArray(TransactionArray value) {
        return new JAXBElement<TransactionArray>(_TransactionArray_QNAME, TransactionArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBlockHeightByTxId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_block_height_by_tx_id")
    public JAXBElement<GetBlockHeightByTxId> createGetBlockHeightByTxId(GetBlockHeightByTxId value) {
        return new JAXBElement<GetBlockHeightByTxId>(_GetBlockHeightByTxId_QNAME, GetBlockHeightByTxId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConditionDetailDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "ConditionDetailDetail")
    public JAXBElement<ConditionDetailDetail> createConditionDetailDetail(ConditionDetailDetail value) {
        return new JAXBElement<ConditionDetailDetail>(_ConditionDetailDetail_QNAME, ConditionDetailDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferTransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "transfer_transactionResponse")
    public JAXBElement<TransferTransactionResponse> createTransferTransactionResponse(TransferTransactionResponse value) {
        return new JAXBElement<TransferTransactionResponse>(_TransferTransactionResponse_QNAME, TransferTransactionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "VoteArray")
    public JAXBElement<VoteArray> createVoteArray(VoteArray value) {
        return new JAXBElement<VoteArray>(_VoteArray_QNAME, VoteArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTxById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_tx_by_id")
    public JAXBElement<GetTxById> createGetTxById(GetTxById value) {
        return new JAXBElement<GetTxById>(_GetTxById_QNAME, GetTxById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraceTransactions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "trace_transactions")
    public JAXBElement<TraceTransactions> createTraceTransactions(TraceTransactions value) {
        return new JAXBElement<TraceTransactions>(_TraceTransactions_QNAME, TraceTransactions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Payload }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "Payload")
    public JAXBElement<Payload> createPayload(Payload value) {
        return new JAXBElement<Payload>(_Payload_QNAME, Payload.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConditionDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "ConditionDetail")
    public JAXBElement<ConditionDetail> createConditionDetail(ConditionDetail value) {
        return new JAXBElement<ConditionDetail>(_ConditionDetail_QNAME, ConditionDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConditionArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "ConditionArray")
    public JAXBElement<ConditionArray> createConditionArray(ConditionArray value) {
        return new JAXBElement<ConditionArray>(_ConditionArray_QNAME, ConditionArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Transaction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "Transaction")
    public JAXBElement<Transaction> createTransaction(Transaction value) {
        return new JAXBElement<Transaction>(_Transaction_QNAME, Transaction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "Input")
    public JAXBElement<Input> createInput(Input value) {
        return new JAXBElement<Input>(_Input_QNAME, Input.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LastTx }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "LastTx")
    public JAXBElement<LastTx> createLastTx(LastTx value) {
        return new JAXBElement<LastTx>(_LastTx_QNAME, LastTx.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TxPair }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "TxPair")
    public JAXBElement<TxPair> createTxPair(TxPair value) {
        return new JAXBElement<TxPair>(_TxPair_QNAME, TxPair.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastTx }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_last_tx")
    public JAXBElement<GetLastTx> createGetLastTx(GetLastTx value) {
        return new JAXBElement<GetLastTx>(_GetLastTx_QNAME, GetLastTx.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraceTransactionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "trace_transactionsResponse")
    public JAXBElement<TraceTransactionsResponse> createTraceTransactionsResponse(TraceTransactionsResponse value) {
        return new JAXBElement<TraceTransactionsResponse>(_TraceTransactionsResponse_QNAME, TraceTransactionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Fulfillment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "Fulfillment")
    public JAXBElement<Fulfillment> createFulfillment(Fulfillment value) {
        return new JAXBElement<Fulfillment>(_Fulfillment_QNAME, Fulfillment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Condition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "Condition")
    public JAXBElement<Condition> createCondition(Condition value) {
        return new JAXBElement<Condition>(_Condition_QNAME, Condition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KeyPair }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "KeyPair")
    public JAXBElement<KeyPair> createKeyPair(KeyPair value) {
        return new JAXBElement<KeyPair>(_KeyPair_QNAME, KeyPair.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBlockByHeight }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_block_by_height")
    public JAXBElement<GetBlockByHeight> createGetBlockByHeight(GetBlockByHeight value) {
        return new JAXBElement<GetBlockByHeight>(_GetBlockByHeight_QNAME, GetBlockByHeight.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "VoteDetail")
    public JAXBElement<VoteDetail> createVoteDetail(VoteDetail value) {
        return new JAXBElement<VoteDetail>(_VoteDetail_QNAME, VoteDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubFulfillment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "SubFulfillment")
    public JAXBElement<SubFulfillment> createSubFulfillment(SubFulfillment value) {
        return new JAXBElement<SubFulfillment>(_SubFulfillment_QNAME, SubFulfillment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Who }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "Who")
    public JAXBElement<Who> createWho(Who value) {
        return new JAXBElement<Who>(_Who_QNAME, Who.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBlockByTxId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_block_by_tx_id")
    public JAXBElement<GetBlockByTxId> createGetBlockByTxId(GetBlockByTxId value) {
        return new JAXBElement<GetBlockByTxId>(_GetBlockByTxId_QNAME, GetBlockByTxId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBlockHeightByTxIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_block_height_by_tx_idResponse")
    public JAXBElement<GetBlockHeightByTxIdResponse> createGetBlockHeightByTxIdResponse(GetBlockHeightByTxIdResponse value) {
        return new JAXBElement<GetBlockHeightByTxIdResponse>(_GetBlockHeightByTxIdResponse_QNAME, GetBlockHeightByTxIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FulfillmentArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "FulfillmentArray")
    public JAXBElement<FulfillmentArray> createFulfillmentArray(FulfillmentArray value) {
        return new JAXBElement<FulfillmentArray>(_FulfillmentArray_QNAME, FulfillmentArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "TransactionDetail")
    public JAXBElement<TransactionDetail> createTransactionDetail(TransactionDetail value) {
        return new JAXBElement<TransactionDetail>(_TransactionDetail_QNAME, TransactionDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Where }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "Where")
    public JAXBElement<Where> createWhere(Where value) {
        return new JAXBElement<Where>(_Where_QNAME, Where.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastBlock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_last_block")
    public JAXBElement<GetLastBlock> createGetLastBlock(GetLastBlock value) {
        return new JAXBElement<GetLastBlock>(_GetLastBlock_QNAME, GetLastBlock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Data }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "Data")
    public JAXBElement<Data> createData(Data value) {
        return new JAXBElement<Data>(_Data_QNAME, Data.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link When }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "When")
    public JAXBElement<When> createWhen(When value) {
        return new JAXBElement<When>(_When_QNAME, When.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WhereItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "WhereItem")
    public JAXBElement<WhereItem> createWhereItem(WhereItem value) {
        return new JAXBElement<WhereItem>(_WhereItem_QNAME, WhereItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTxsByBlockAddrResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_txs_by_block_addrResponse")
    public JAXBElement<GetTxsByBlockAddrResponse> createGetTxsByBlockAddrResponse(GetTxsByBlockAddrResponse value) {
        return new JAXBElement<GetTxsByBlockAddrResponse>(_GetTxsByBlockAddrResponse_QNAME, GetTxsByBlockAddrResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigBlock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "BigBlock")
    public JAXBElement<BigBlock> createBigBlock(BigBlock value) {
        return new JAXBElement<BigBlock>(_BigBlock_QNAME, BigBlock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Thing }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "Thing")
    public JAXBElement<Thing> createThing(Thing value) {
        return new JAXBElement<Thing>(_Thing_QNAME, Thing.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferTransaction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "transfer_transaction")
    public JAXBElement<TransferTransaction> createTransferTransaction(TransferTransaction value) {
        return new JAXBElement<TransferTransaction>(_TransferTransaction_QNAME, TransferTransaction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "create_transactionResponse")
    public JAXBElement<CreateTransactionResponse> createCreateTransactionResponse(CreateTransactionResponse value) {
        return new JAXBElement<CreateTransactionResponse>(_CreateTransactionResponse_QNAME, CreateTransactionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastTxResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_last_txResponse")
    public JAXBElement<GetLastTxResponse> createGetLastTxResponse(GetLastTxResponse value) {
        return new JAXBElement<GetLastTxResponse>(_GetLastTxResponse_QNAME, GetLastTxResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LastBlock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "LastBlock")
    public JAXBElement<LastBlock> createLastBlock(LastBlock value) {
        return new JAXBElement<LastBlock>(_LastBlock_QNAME, LastBlock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKeyPair }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_key_pair")
    public JAXBElement<GetKeyPair> createGetKeyPair(GetKeyPair value) {
        return new JAXBElement<GetKeyPair>(_GetKeyPair_QNAME, GetKeyPair.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKeyPairResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_key_pairResponse")
    public JAXBElement<GetKeyPairResponse> createGetKeyPairResponse(GetKeyPairResponse value) {
        return new JAXBElement<GetKeyPairResponse>(_GetKeyPairResponse_QNAME, GetKeyPairResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "id", scope = GetTxById.class)
    public JAXBElement<String> createGetTxByIdId(String value) {
        return new JAXBElement<String>(_GetTxByIdId_QNAME, String.class, GetTxById.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "transfer_transactionResult", scope = TransferTransactionResponse.class)
    public JAXBElement<TransferResult> createTransferTransactionResponseTransferTransactionResult(TransferResult value) {
        return new JAXBElement<TransferResult>(_TransferTransactionResponseTransferTransactionResult_QNAME, TransferResult.class, TransferTransactionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "tx_id", scope = GetBlockByTxId.class)
    public JAXBElement<String> createGetBlockByTxIdTxId(String value) {
        return new JAXBElement<String>(_GetBlockByTxIdTxId_QNAME, String.class, GetBlockByTxId.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "node_pubkey", scope = LastBlock.class)
    public JAXBElement<String> createLastBlockNodePubkey(String value) {
        return new JAXBElement<String>(_LastBlockNodePubkey_QNAME, String.class, LastBlock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "height", scope = LastBlock.class)
    public JAXBElement<String> createLastBlockHeight(String value) {
        return new JAXBElement<String>(_LastBlockHeight_QNAME, String.class, LastBlock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "timestamp", scope = LastBlock.class)
    public JAXBElement<String> createLastBlockTimestamp(String value) {
        return new JAXBElement<String>(_LastBlockTimestamp_QNAME, String.class, LastBlock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "tx_ids", scope = LastBlock.class)
    public JAXBElement<StringArray> createLastBlockTxIds(StringArray value) {
        return new JAXBElement<StringArray>(_LastBlockTxIds_QNAME, StringArray.class, LastBlock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "invalid_reason", scope = VoteDetail.class)
    public JAXBElement<String> createVoteDetailInvalidReason(String value) {
        return new JAXBElement<String>(_VoteDetailInvalidReason_QNAME, String.class, VoteDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "previous_block", scope = VoteDetail.class)
    public JAXBElement<String> createVoteDetailPreviousBlock(String value) {
        return new JAXBElement<String>(_VoteDetailPreviousBlock_QNAME, String.class, VoteDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "voting_for_block", scope = VoteDetail.class)
    public JAXBElement<String> createVoteDetailVotingForBlock(String value) {
        return new JAXBElement<String>(_VoteDetailVotingForBlock_QNAME, String.class, VoteDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsBlockValid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "is_block_valid", scope = VoteDetail.class)
    public JAXBElement<IsBlockValid> createVoteDetailIsBlockValid(IsBlockValid value) {
        return new JAXBElement<IsBlockValid>(_VoteDetailIsBlockValid_QNAME, IsBlockValid.class, VoteDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "timestamp", scope = VoteDetail.class)
    public JAXBElement<String> createVoteDetailTimestamp(String value) {
        return new JAXBElement<String>(_LastBlockTimestamp_QNAME, String.class, VoteDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "origin_place", scope = Thing.class)
    public JAXBElement<String> createThingOriginPlace(String value) {
        return new JAXBElement<String>(_ThingOriginPlace_QNAME, String.class, Thing.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "thing_order_batch", scope = Thing.class)
    public JAXBElement<String> createThingThingOrderBatch(String value) {
        return new JAXBElement<String>(_ThingThingOrderBatch_QNAME, String.class, Thing.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "thing_order_quantity", scope = Thing.class)
    public JAXBElement<String> createThingThingOrderQuantity(String value) {
        return new JAXBElement<String>(_ThingThingOrderQuantity_QNAME, String.class, Thing.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "thing_id", scope = Thing.class)
    public JAXBElement<String> createThingThingId(String value) {
        return new JAXBElement<String>(_ThingThingId_QNAME, String.class, Thing.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "thing_type_id", scope = Thing.class)
    public JAXBElement<String> createThingThingTypeId(String value) {
        return new JAXBElement<String>(_ThingThingTypeId_QNAME, String.class, Thing.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "price", scope = Thing.class)
    public JAXBElement<String> createThingPrice(String value) {
        return new JAXBElement<String>(_ThingPrice_QNAME, String.class, Thing.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "thing_name", scope = Thing.class)
    public JAXBElement<String> createThingThingName(String value) {
        return new JAXBElement<String>(_ThingThingName_QNAME, String.class, Thing.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "thing_type_name", scope = Thing.class)
    public JAXBElement<String> createThingThingTypeName(String value) {
        return new JAXBElement<String>(_ThingThingTypeName_QNAME, String.class, Thing.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KeyPair }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_key_pairResult", scope = GetKeyPairResponse.class)
    public JAXBElement<KeyPair> createGetKeyPairResponseGetKeyPairResult(KeyPair value) {
        return new JAXBElement<KeyPair>(_GetKeyPairResponseGetKeyPairResult_QNAME, KeyPair.class, GetKeyPairResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_block_height_by_tx_idResult", scope = GetBlockHeightByTxIdResponse.class)
    public JAXBElement<BigInteger> createGetBlockHeightByTxIdResponseGetBlockHeightByTxIdResult(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetBlockHeightByTxIdResponseGetBlockHeightByTxIdResult_QNAME, BigInteger.class, GetBlockHeightByTxIdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "tx_originator_private_key", scope = TransferTransaction.class)
    public JAXBElement<String> createTransferTransactionTxOriginatorPrivateKey(String value) {
        return new JAXBElement<String>(_TransferTransactionTxOriginatorPrivateKey_QNAME, String.class, TransferTransaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "tx_recipient_public_key", scope = TransferTransaction.class)
    public JAXBElement<String> createTransferTransactionTxRecipientPublicKey(String value) {
        return new JAXBElement<String>(_TransferTransactionTxRecipientPublicKey_QNAME, String.class, TransferTransaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "tx_originator_public_key", scope = TransferTransaction.class)
    public JAXBElement<String> createTransferTransactionTxOriginatorPublicKey(String value) {
        return new JAXBElement<String>(_TransferTransactionTxOriginatorPublicKey_QNAME, String.class, TransferTransaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link When }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "when", scope = TransferTransaction.class)
    public JAXBElement<When> createTransferTransactionWhen(When value) {
        return new JAXBElement<When>(_TransferTransactionWhen_QNAME, When.class, TransferTransaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Thing }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "thing", scope = TransferTransaction.class)
    public JAXBElement<Thing> createTransferTransactionThing(Thing value) {
        return new JAXBElement<Thing>(_TransferTransactionThing_QNAME, Thing.class, TransferTransaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Who }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "who", scope = TransferTransaction.class)
    public JAXBElement<Who> createTransferTransactionWho(Who value) {
        return new JAXBElement<Who>(_TransferTransactionWho_QNAME, Who.class, TransferTransaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Where }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "where", scope = TransferTransaction.class)
    public JAXBElement<Where> createTransferTransactionWhere(Where value) {
        return new JAXBElement<Where>(_TransferTransactionWhere_QNAME, Where.class, TransferTransaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "addr", scope = GetTxsByBlockAddr.class)
    public JAXBElement<String> createGetTxsByBlockAddrAddr(String value) {
        return new JAXBElement<String>(_GetTxsByBlockAddrAddr_QNAME, String.class, GetTxsByBlockAddr.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Data }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_tx_by_idResult", scope = GetTxByIdResponse.class)
    public JAXBElement<Data> createGetTxByIdResponseGetTxByIdResult(Data value) {
        return new JAXBElement<Data>(_GetTxByIdResponseGetTxByIdResult_QNAME, Data.class, GetTxByIdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "signature", scope = Vote.class)
    public JAXBElement<String> createVoteSignature(String value) {
        return new JAXBElement<String>(_VoteSignature_QNAME, String.class, Vote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "vote", scope = Vote.class)
    public JAXBElement<VoteDetail> createVoteVote(VoteDetail value) {
        return new JAXBElement<VoteDetail>(_VoteVote_QNAME, VoteDetail.class, Vote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "node_pubkey", scope = Vote.class)
    public JAXBElement<String> createVoteNodePubkey(String value) {
        return new JAXBElement<String>(_LastBlockNodePubkey_QNAME, String.class, Vote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LastTx }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_last_txResult", scope = GetLastTxResponse.class)
    public JAXBElement<LastTx> createGetLastTxResponseGetLastTxResult(LastTx value) {
        return new JAXBElement<LastTx>(_GetLastTxResponseGetLastTxResult_QNAME, LastTx.class, GetLastTxResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "cid", scope = Condition.class)
    public JAXBElement<BigInteger> createConditionCid(BigInteger value) {
        return new JAXBElement<BigInteger>(_ConditionCid_QNAME, BigInteger.class, Condition.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "new_owners", scope = Condition.class)
    public JAXBElement<StringArray> createConditionNewOwners(StringArray value) {
        return new JAXBElement<StringArray>(_ConditionNewOwners_QNAME, StringArray.class, Condition.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConditionDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "condition", scope = Condition.class)
    public JAXBElement<ConditionDetail> createConditionCondition(ConditionDetail value) {
        return new JAXBElement<ConditionDetail>(_ConditionCondition_QNAME, ConditionDetail.class, Condition.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "type_id", scope = ConditionDetailDetail.class)
    public JAXBElement<BigInteger> createConditionDetailDetailTypeId(BigInteger value) {
        return new JAXBElement<BigInteger>(_ConditionDetailDetailTypeId_QNAME, BigInteger.class, ConditionDetailDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "signature", scope = ConditionDetailDetail.class)
    public JAXBElement<String> createConditionDetailDetailSignature(String value) {
        return new JAXBElement<String>(_VoteSignature_QNAME, String.class, ConditionDetailDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "threshold", scope = ConditionDetailDetail.class)
    public JAXBElement<BigInteger> createConditionDetailDetailThreshold(BigInteger value) {
        return new JAXBElement<BigInteger>(_ConditionDetailDetailThreshold_QNAME, BigInteger.class, ConditionDetailDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "type", scope = ConditionDetailDetail.class)
    public JAXBElement<String> createConditionDetailDetailType(String value) {
        return new JAXBElement<String>(_ConditionDetailDetailType_QNAME, String.class, ConditionDetailDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "public_key", scope = ConditionDetailDetail.class)
    public JAXBElement<String> createConditionDetailDetailPublicKey(String value) {
        return new JAXBElement<String>(_ConditionDetailDetailPublicKey_QNAME, String.class, ConditionDetailDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "bitmask", scope = ConditionDetailDetail.class)
    public JAXBElement<BigInteger> createConditionDetailDetailBitmask(BigInteger value) {
        return new JAXBElement<BigInteger>(_ConditionDetailDetailBitmask_QNAME, BigInteger.class, ConditionDetailDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubFulfillmentArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "subfulfillments", scope = ConditionDetailDetail.class)
    public JAXBElement<SubFulfillmentArray> createConditionDetailDetailSubfulfillments(SubFulfillmentArray value) {
        return new JAXBElement<SubFulfillmentArray>(_ConditionDetailDetailSubfulfillments_QNAME, SubFulfillmentArray.class, ConditionDetailDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "make_date", scope = When.class)
    public JAXBElement<String> createWhenMakeDate(String value) {
        return new JAXBElement<String>(_WhenMakeDate_QNAME, String.class, When.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "receive_date", scope = When.class)
    public JAXBElement<String> createWhenReceiveDate(String value) {
        return new JAXBElement<String>(_WhenReceiveDate_QNAME, String.class, When.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "send_date", scope = When.class)
    public JAXBElement<String> createWhenSendDate(String value) {
        return new JAXBElement<String>(_WhenSendDate_QNAME, String.class, When.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "expire_date", scope = When.class)
    public JAXBElement<String> createWhenExpireDate(String value) {
        return new JAXBElement<String>(_WhenExpireDate_QNAME, String.class, When.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "current_owners", scope = Fulfillment.class)
    public JAXBElement<StringArray> createFulfillmentCurrentOwners(StringArray value) {
        return new JAXBElement<StringArray>(_FulfillmentCurrentOwners_QNAME, StringArray.class, Fulfillment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "fulfillment", scope = Fulfillment.class)
    public JAXBElement<String> createFulfillmentFulfillment(String value) {
        return new JAXBElement<String>(_FulfillmentFulfillment_QNAME, String.class, Fulfillment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "input", scope = Fulfillment.class)
    public JAXBElement<Input> createFulfillmentInput(Input value) {
        return new JAXBElement<Input>(_FulfillmentInput_QNAME, Input.class, Fulfillment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "fid", scope = Fulfillment.class)
    public JAXBElement<BigInteger> createFulfillmentFid(BigInteger value) {
        return new JAXBElement<BigInteger>(_FulfillmentFid_QNAME, BigInteger.class, Fulfillment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "voters", scope = Block.class)
    public JAXBElement<StringArray> createBlockVoters(StringArray value) {
        return new JAXBElement<StringArray>(_BlockVoters_QNAME, StringArray.class, Block.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "node_pubkey", scope = Block.class)
    public JAXBElement<String> createBlockNodePubkey(String value) {
        return new JAXBElement<String>(_LastBlockNodePubkey_QNAME, String.class, Block.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "timestamp", scope = Block.class)
    public JAXBElement<String> createBlockTimestamp(String value) {
        return new JAXBElement<String>(_LastBlockTimestamp_QNAME, String.class, Block.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "transactions", scope = Block.class)
    public JAXBElement<TransactionArray> createBlockTransactions(TransactionArray value) {
        return new JAXBElement<TransactionArray>(_BlockTransactions_QNAME, TransactionArray.class, Block.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "uuid", scope = Data.class)
    public JAXBElement<String> createDataUuid(String value) {
        return new JAXBElement<String>(_DataUuid_QNAME, String.class, Data.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Payload }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "payload", scope = Data.class)
    public JAXBElement<Payload> createDataPayload(Payload value) {
        return new JAXBElement<Payload>(_DataPayload_QNAME, Payload.class, Data.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigBlock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_block_by_tx_idResult", scope = GetBlockByTxIdResponse.class)
    public JAXBElement<BigBlock> createGetBlockByTxIdResponseGetBlockByTxIdResult(BigBlock value) {
        return new JAXBElement<BigBlock>(_GetBlockByTxIdResponseGetBlockByTxIdResult_QNAME, BigBlock.class, GetBlockByTxIdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WhereItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "goto", scope = Where.class)
    public JAXBElement<WhereItem> createWhereGoto(WhereItem value) {
        return new JAXBElement<WhereItem>(_WhereGoto_QNAME, WhereItem.class, Where.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WhereItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "original", scope = Where.class)
    public JAXBElement<WhereItem> createWhereOriginal(WhereItem value) {
        return new JAXBElement<WhereItem>(_WhereOriginal_QNAME, WhereItem.class, Where.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "type_id", scope = SubFulfillment.class)
    public JAXBElement<BigInteger> createSubFulfillmentTypeId(BigInteger value) {
        return new JAXBElement<BigInteger>(_ConditionDetailDetailTypeId_QNAME, BigInteger.class, SubFulfillment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "signature", scope = SubFulfillment.class)
    public JAXBElement<String> createSubFulfillmentSignature(String value) {
        return new JAXBElement<String>(_VoteSignature_QNAME, String.class, SubFulfillment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "type", scope = SubFulfillment.class)
    public JAXBElement<String> createSubFulfillmentType(String value) {
        return new JAXBElement<String>(_ConditionDetailDetailType_QNAME, String.class, SubFulfillment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "public_key", scope = SubFulfillment.class)
    public JAXBElement<String> createSubFulfillmentPublicKey(String value) {
        return new JAXBElement<String>(_ConditionDetailDetailPublicKey_QNAME, String.class, SubFulfillment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "bitmask", scope = SubFulfillment.class)
    public JAXBElement<BigInteger> createSubFulfillmentBitmask(BigInteger value) {
        return new JAXBElement<BigInteger>(_ConditionDetailDetailBitmask_QNAME, BigInteger.class, SubFulfillment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "weight", scope = SubFulfillment.class)
    public JAXBElement<BigInteger> createSubFulfillmentWeight(BigInteger value) {
        return new JAXBElement<BigInteger>(_SubFulfillmentWeight_QNAME, BigInteger.class, SubFulfillment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "version", scope = Transaction.class)
    public JAXBElement<BigInteger> createTransactionVersion(BigInteger value) {
        return new JAXBElement<BigInteger>(_TransactionVersion_QNAME, BigInteger.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "transaction", scope = Transaction.class)
    public JAXBElement<TransactionDetail> createTransactionTransaction(TransactionDetail value) {
        return new JAXBElement<TransactionDetail>(_TransactionTransaction_QNAME, TransactionDetail.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "id", scope = Transaction.class)
    public JAXBElement<String> createTransactionId(String value) {
        return new JAXBElement<String>(_TransactionId_QNAME, String.class, Transaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "uri", scope = ConditionDetail.class)
    public JAXBElement<String> createConditionDetailUri(String value) {
        return new JAXBElement<String>(_ConditionDetailUri_QNAME, String.class, ConditionDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConditionDetailDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "details", scope = ConditionDetail.class)
    public JAXBElement<ConditionDetailDetail> createConditionDetailDetails(ConditionDetailDetail value) {
        return new JAXBElement<ConditionDetailDetail>(_ConditionDetailDetails_QNAME, ConditionDetailDetail.class, ConditionDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_txs_by_block_addrResult", scope = GetTxsByBlockAddrResponse.class)
    public JAXBElement<TransactionArray> createGetTxsByBlockAddrResponseGetTxsByBlockAddrResult(TransactionArray value) {
        return new JAXBElement<TransactionArray>(_GetTxsByBlockAddrResponseGetTxsByBlockAddrResult_QNAME, TransactionArray.class, GetTxsByBlockAddrResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "public_key", scope = TraceTransactions.class)
    public JAXBElement<String> createTraceTransactionsPublicKey(String value) {
        return new JAXBElement<String>(_TraceTransactionsPublicKey_QNAME, String.class, TraceTransactions.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WhoItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "goto", scope = Who.class)
    public JAXBElement<WhoItem> createWhoGoto(WhoItem value) {
        return new JAXBElement<WhoItem>(_WhereGoto_QNAME, WhoItem.class, Who.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WhoItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "original", scope = Who.class)
    public JAXBElement<WhoItem> createWhoOriginal(WhoItem value) {
        return new JAXBElement<WhoItem>(_WhereOriginal_QNAME, WhoItem.class, Who.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KeyPair }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "new_key_pair", scope = TransferResult.class)
    public JAXBElement<KeyPair> createTransferResultNewKeyPair(KeyPair value) {
        return new JAXBElement<KeyPair>(_TransferResultNewKeyPair_QNAME, KeyPair.class, TransferResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "message", scope = TransferResult.class)
    public JAXBElement<String> createTransferResultMessage(String value) {
        return new JAXBElement<String>(_TransferResultMessage_QNAME, String.class, TransferResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TxPair }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "txs", scope = TransferResult.class)
    public JAXBElement<TxPair> createTransferResultTxs(TxPair value) {
        return new JAXBElement<TxPair>(_TransferResultTxs_QNAME, TxPair.class, TransferResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "transfer_id", scope = TxPair.class)
    public JAXBElement<String> createTxPairTransferId(String value) {
        return new JAXBElement<String>(_TxPairTransferId_QNAME, String.class, TxPair.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "create_id", scope = TxPair.class)
    public JAXBElement<String> createTxPairCreateId(String value) {
        return new JAXBElement<String>(_TxPairCreateId_QNAME, String.class, TxPair.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "cid", scope = Input.class)
    public JAXBElement<BigInteger> createInputCid(BigInteger value) {
        return new JAXBElement<BigInteger>(_ConditionCid_QNAME, BigInteger.class, Input.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "txid", scope = Input.class)
    public JAXBElement<String> createInputTxid(String value) {
        return new JAXBElement<String>(_InputTxid_QNAME, String.class, Input.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "user_id", scope = WhoItem.class)
    public JAXBElement<String> createWhoItemUserId(String value) {
        return new JAXBElement<String>(_WhoItemUserId_QNAME, String.class, WhoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "u_company_id", scope = WhoItem.class)
    public JAXBElement<String> createWhoItemUCompanyId(String value) {
        return new JAXBElement<String>(_WhoItemUCompanyId_QNAME, String.class, WhoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "company_name", scope = WhoItem.class)
    public JAXBElement<String> createWhoItemCompanyName(String value) {
        return new JAXBElement<String>(_WhoItemCompanyName_QNAME, String.class, WhoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "user_type", scope = WhoItem.class)
    public JAXBElement<String> createWhoItemUserType(String value) {
        return new JAXBElement<String>(_WhoItemUserType_QNAME, String.class, WhoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "company_id", scope = WhoItem.class)
    public JAXBElement<String> createWhoItemCompanyId(String value) {
        return new JAXBElement<String>(_WhoItemCompanyId_QNAME, String.class, WhoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "user_name", scope = WhoItem.class)
    public JAXBElement<String> createWhoItemUserName(String value) {
        return new JAXBElement<String>(_WhoItemUserName_QNAME, String.class, WhoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "nation", scope = WhereItem.class)
    public JAXBElement<String> createWhereItemNation(String value) {
        return new JAXBElement<String>(_WhereItemNation_QNAME, String.class, WhereItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "place", scope = WhereItem.class)
    public JAXBElement<String> createWhereItemPlace(String value) {
        return new JAXBElement<String>(_WhereItemPlace_QNAME, String.class, WhereItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "region_id", scope = WhereItem.class)
    public JAXBElement<String> createWhereItemRegionId(String value) {
        return new JAXBElement<String>(_WhereItemRegionId_QNAME, String.class, WhereItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "region", scope = WhereItem.class)
    public JAXBElement<String> createWhereItemRegion(String value) {
        return new JAXBElement<String>(_WhereItemRegion_QNAME, String.class, WhereItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "height", scope = GetBlockByHeight.class)
    public JAXBElement<BigInteger> createGetBlockByHeightHeight(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetBlockByHeightHeight_QNAME, BigInteger.class, GetBlockByHeight.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "create_transactionResult", scope = CreateTransactionResponse.class)
    public JAXBElement<String> createCreateTransactionResponseCreateTransactionResult(String value) {
        return new JAXBElement<String>(_CreateTransactionResponseCreateTransactionResult_QNAME, String.class, CreateTransactionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LastBlock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_last_blockResult", scope = GetLastBlockResponse.class)
    public JAXBElement<LastBlock> createGetLastBlockResponseGetLastBlockResult(LastBlock value) {
        return new JAXBElement<LastBlock>(_GetLastBlockResponseGetLastBlockResult_QNAME, LastBlock.class, GetLastBlockResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Thing }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "thing", scope = Payload.class)
    public JAXBElement<Thing> createPayloadThing(Thing value) {
        return new JAXBElement<Thing>(_PayloadThing_QNAME, Thing.class, Payload.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Who }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "who", scope = Payload.class)
    public JAXBElement<Who> createPayloadWho(Who value) {
        return new JAXBElement<Who>(_PayloadWho_QNAME, Who.class, Payload.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Where }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "where", scope = Payload.class)
    public JAXBElement<Where> createPayloadWhere(Where value) {
        return new JAXBElement<Where>(_PayloadWhere_QNAME, Where.class, Payload.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "previous_process_tx_id", scope = Payload.class)
    public JAXBElement<String> createPayloadPreviousProcessTxId(String value) {
        return new JAXBElement<String>(_PayloadPreviousProcessTxId_QNAME, String.class, Payload.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link When }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "when", scope = Payload.class)
    public JAXBElement<When> createPayloadWhen(When value) {
        return new JAXBElement<When>(_PayloadWhen_QNAME, When.class, Payload.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigBlock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "get_block_by_heightResult", scope = GetBlockByHeightResponse.class)
    public JAXBElement<BigBlock> createGetBlockByHeightResponseGetBlockByHeightResult(BigBlock value) {
        return new JAXBElement<BigBlock>(_GetBlockByHeightResponseGetBlockByHeightResult_QNAME, BigBlock.class, GetBlockByHeightResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "trace_transactionsResult", scope = TraceTransactionsResponse.class)
    public JAXBElement<StringArray> createTraceTransactionsResponseTraceTransactionsResult(StringArray value) {
        return new JAXBElement<StringArray>(_TraceTransactionsResponseTraceTransactionsResult_QNAME, StringArray.class, TraceTransactionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "tx_recipient", scope = LastTx.class)
    public JAXBElement<StringArray> createLastTxTxRecipient(StringArray value) {
        return new JAXBElement<StringArray>(_LastTxTxRecipient_QNAME, StringArray.class, LastTx.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "tx_id", scope = LastTx.class)
    public JAXBElement<String> createLastTxTxId(String value) {
        return new JAXBElement<String>(_LastTxTxId_QNAME, String.class, LastTx.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "tx_originator", scope = LastTx.class)
    public JAXBElement<StringArray> createLastTxTxOriginator(StringArray value) {
        return new JAXBElement<StringArray>(_LastTxTxOriginator_QNAME, StringArray.class, LastTx.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "timestamp", scope = LastTx.class)
    public JAXBElement<String> createLastTxTimestamp(String value) {
        return new JAXBElement<String>(_LastBlockTimestamp_QNAME, String.class, LastTx.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "signature", scope = BigBlock.class)
    public JAXBElement<String> createBigBlockSignature(String value) {
        return new JAXBElement<String>(_VoteSignature_QNAME, String.class, BigBlock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "block_number", scope = BigBlock.class)
    public JAXBElement<BigInteger> createBigBlockBlockNumber(BigInteger value) {
        return new JAXBElement<BigInteger>(_BigBlockBlockNumber_QNAME, BigInteger.class, BigBlock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "votes", scope = BigBlock.class)
    public JAXBElement<VoteArray> createBigBlockVotes(VoteArray value) {
        return new JAXBElement<VoteArray>(_BigBlockVotes_QNAME, VoteArray.class, BigBlock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Block }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "block", scope = BigBlock.class)
    public JAXBElement<Block> createBigBlockBlock(Block value) {
        return new JAXBElement<Block>(_BigBlockBlock_QNAME, Block.class, BigBlock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "id", scope = BigBlock.class)
    public JAXBElement<String> createBigBlockId(String value) {
        return new JAXBElement<String>(_TransactionId_QNAME, String.class, BigBlock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Data }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "data", scope = TransactionDetail.class)
    public JAXBElement<Data> createTransactionDetailData(Data value) {
        return new JAXBElement<Data>(_TransactionDetailData_QNAME, Data.class, TransactionDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConditionArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "conditions", scope = TransactionDetail.class)
    public JAXBElement<ConditionArray> createTransactionDetailConditions(ConditionArray value) {
        return new JAXBElement<ConditionArray>(_TransactionDetailConditions_QNAME, ConditionArray.class, TransactionDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "timestamp", scope = TransactionDetail.class)
    public JAXBElement<String> createTransactionDetailTimestamp(String value) {
        return new JAXBElement<String>(_LastBlockTimestamp_QNAME, String.class, TransactionDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "operation", scope = TransactionDetail.class)
    public JAXBElement<String> createTransactionDetailOperation(String value) {
        return new JAXBElement<String>(_TransactionDetailOperation_QNAME, String.class, TransactionDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FulfillmentArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "fulfillments", scope = TransactionDetail.class)
    public JAXBElement<FulfillmentArray> createTransactionDetailFulfillments(FulfillmentArray value) {
        return new JAXBElement<FulfillmentArray>(_TransactionDetailFulfillments_QNAME, FulfillmentArray.class, TransactionDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "tx_id", scope = GetBlockHeightByTxId.class)
    public JAXBElement<String> createGetBlockHeightByTxIdTxId(String value) {
        return new JAXBElement<String>(_GetBlockByTxIdTxId_QNAME, String.class, GetBlockHeightByTxId.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "public_key", scope = KeyPair.class)
    public JAXBElement<String> createKeyPairPublicKey(String value) {
        return new JAXBElement<String>(_ConditionDetailDetailPublicKey_QNAME, String.class, KeyPair.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "soap_rpc.models", name = "private_key", scope = KeyPair.class)
    public JAXBElement<String> createKeyPairPrivateKey(String value) {
        return new JAXBElement<String>(_KeyPairPrivateKey_QNAME, String.class, KeyPair.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link When }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "when", scope = CreateTransaction.class)
    public JAXBElement<When> createCreateTransactionWhen(When value) {
        return new JAXBElement<When>(_TransferTransactionWhen_QNAME, When.class, CreateTransaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "public_key", scope = CreateTransaction.class)
    public JAXBElement<String> createCreateTransactionPublicKey(String value) {
        return new JAXBElement<String>(_TraceTransactionsPublicKey_QNAME, String.class, CreateTransaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Thing }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "thing", scope = CreateTransaction.class)
    public JAXBElement<Thing> createCreateTransactionThing(Thing value) {
        return new JAXBElement<Thing>(_TransferTransactionThing_QNAME, Thing.class, CreateTransaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Who }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "who", scope = CreateTransaction.class)
    public JAXBElement<Who> createCreateTransactionWho(Who value) {
        return new JAXBElement<Who>(_TransferTransactionWho_QNAME, Who.class, CreateTransaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Where }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.examples.rpc", name = "where", scope = CreateTransaction.class)
    public JAXBElement<Where> createCreateTransactionWhere(Where value) {
        return new JAXBElement<Where>(_TransferTransactionWhere_QNAME, Where.class, CreateTransaction.class, value);
    }

}
