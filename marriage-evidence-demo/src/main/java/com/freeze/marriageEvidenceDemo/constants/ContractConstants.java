package com.freeze.marriageEvidenceDemo.constants;

import java.lang.Exception;
import java.lang.RuntimeException;
import java.lang.String;

public class ContractConstants {
  public static String MarriageEvidenceAbi;

  public static String MarriageEvidenceBinary;

  public static String MarriageEvidenceGmBinary;

  static {
    try {
      MarriageEvidenceAbi = org.apache.commons.io.IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource("abi/MarriageEvidence.abi"));
      MarriageEvidenceBinary = org.apache.commons.io.IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource("bin/ecc/MarriageEvidence.bin"));
      MarriageEvidenceGmBinary = org.apache.commons.io.IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource("bin/sm/MarriageEvidence.bin"));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
