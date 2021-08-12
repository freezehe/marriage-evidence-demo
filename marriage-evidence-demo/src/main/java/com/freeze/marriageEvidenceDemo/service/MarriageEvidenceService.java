package com.freeze.marriageEvidenceDemo.service;

import com.freeze.marriageEvidenceDemo.constants.ContractConstants;
import com.freeze.marriageEvidenceDemo.model.bo.MarriageEvidenceAddCharacterInputBO;
import com.freeze.marriageEvidenceDemo.model.bo.MarriageEvidenceIsCharacterInputBO;
import com.freeze.marriageEvidenceDemo.model.bo.MarriageEvidenceNewEviInputBO;
import com.freeze.marriageEvidenceDemo.model.bo.MarriageEvidenceRemoveCharacterInputBO;
import com.freeze.marriageEvidenceDemo.model.bo.MarriageEvidenceReviseCharacterInputBO;
import com.freeze.marriageEvidenceDemo.model.bo.MarriageEvidenceSeekCharacterInputBO;
import java.lang.Exception;
import java.lang.String;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor;
import org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory;
import org.fisco.bcos.sdk.transaction.model.dto.CallResponse;
import org.fisco.bcos.sdk.transaction.model.dto.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Data
public class MarriageEvidenceService {
  @Value("${contract.marriageEvidenceAddress}")
  private String address;

  @Autowired
  private Client client;

  AssembleTransactionProcessor txProcessor;

  @PostConstruct
  public void init() throws Exception {
    this.txProcessor = TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, this.client.getCryptoSuite().getCryptoKeyPair());
  }

  public CallResponse getAllCharater() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ContractConstants.MarriageEvidenceAbi, "getAllCharater", Arrays.asList());
  }

  public CallResponse isCharacter(MarriageEvidenceIsCharacterInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ContractConstants.MarriageEvidenceAbi, "isCharacter", input.toArgs());
  }

  public CallResponse getEvi() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ContractConstants.MarriageEvidenceAbi, "getEvi", Arrays.asList());
  }

  public TransactionResponse reviseCharacter(MarriageEvidenceReviseCharacterInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.MarriageEvidenceAbi, "reviseCharacter", input.toArgs());
  }

  public TransactionResponse removeCharacter(MarriageEvidenceRemoveCharacterInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.MarriageEvidenceAbi, "removeCharacter", input.toArgs());
  }

  public TransactionResponse deployEvi() throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.MarriageEvidenceAbi, "deployEvi", Arrays.asList());
  }

  public CallResponse seekCharacter(MarriageEvidenceSeekCharacterInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ContractConstants.MarriageEvidenceAbi, "seekCharacter", input.toArgs());
  }

  public CallResponse getSigners() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ContractConstants.MarriageEvidenceAbi, "getSigners", Arrays.asList());
  }

  public TransactionResponse newEvi(MarriageEvidenceNewEviInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.MarriageEvidenceAbi, "newEvi", input.toArgs());
  }

  public TransactionResponse addCharacter(MarriageEvidenceAddCharacterInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.MarriageEvidenceAbi, "addCharacter", input.toArgs());
  }

  public TransactionResponse sign() throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.MarriageEvidenceAbi, "sign", Arrays.asList());
  }
}
