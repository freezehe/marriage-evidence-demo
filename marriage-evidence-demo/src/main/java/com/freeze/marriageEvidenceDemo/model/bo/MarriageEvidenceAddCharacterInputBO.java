package com.freeze.marriageEvidenceDemo.model.bo;

import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarriageEvidenceAddCharacterInputBO {
  private String amount;

  private String _summary;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(amount);
    args.add(_summary);
    return args;
  }
}
