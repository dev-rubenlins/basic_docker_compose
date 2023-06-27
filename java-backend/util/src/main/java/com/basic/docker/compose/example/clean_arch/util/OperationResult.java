package com.basic.docker.compose.example.clean_arch.util;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class OperationResult {

    private ResultType resultType;

    private Optional<List<String>> occurrences;

    private boolean sameResultType(OperationResult other) {
        return this.resultType.equals(other.getResultType());
    }

    private List<String> joinOccurrenceLists(Optional<List<String>> optLista1, Optional<List<String>> optLista2) {
        List<String> result = new ArrayList<>();
        if (optLista1.isPresent()) {
            result.addAll(optLista1.get());
        }
        if (optLista2.isPresent()) {
            result.addAll(optLista2.get());
        }
        return result;
    }

    public OperationResult mergeResult(@NotNull OperationResult other){

        ResultType resultType = sameResultType(other) ?
                this.resultType : ResultType.FAIL;

        List<String> occurrences = joinOccurrenceLists(this.getOccurrences(), other.getOccurrences());

        OperationResult result =
        switch (resultType) {
            case SUCCESS -> success();
            case FAIL -> fail(occurrences);
        };

        return result;
    }

    public boolean isSuccess(){
        return resultType.equals(ResultType.SUCCESS);
    }

    public boolean hasFailed(){
        return resultType.equals(ResultType.FAIL);
    }

    public static OperationResult success(){
        return OperationResult
                .builder()
                .resultType(ResultType.SUCCESS)
                .build();
    }

    public static OperationResult fail() {
        return OperationResult
                .builder()
                .resultType(ResultType.FAIL)
                .build();
    }

    public static OperationResult fail(@NotNull List<String> occurrences) {
        return OperationResult
                .builder()
                .resultType(ResultType.FAIL)
                .occurrences(Optional.of(occurrences))
                .build();
    }
}
