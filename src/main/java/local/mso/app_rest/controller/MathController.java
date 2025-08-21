package local.mso.app_rest.controller;


import local.mso.app_rest.exception.ExceptionResponseOrigin;
import local.mso.app_rest.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) {
            if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
                throw new UnsupportedMathOperationException("Please Enter with numeric value");
            }
             return converToDouble(numberOne) + converToDouble(numberTwo);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber.isEmpty() || strNumber == null) return false;
        String number = strNumber.replace(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private Double converToDouble(String strNumber) {
        if (strNumber.isEmpty() || strNumber == null) throw new UnsupportedMathOperationException("Please Enter with numeric value");
        String number = strNumber.replace(",",".");
        return Double.parseDouble(strNumber);
    }
}
