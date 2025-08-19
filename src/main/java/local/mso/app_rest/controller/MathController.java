package local.mso.app_rest.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo
    ) throws IllegalArgumentException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new IllegalArgumentException();
             return converToDouble(numberOne) + converToDouble(numberTwo);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber.isEmpty() || strNumber == null) return false;
        String number = strNumber.replace(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private Double converToDouble(String strNumber) throws IllegalArgumentException {
        if (strNumber.isEmpty() || strNumber == null) throw new IllegalArgumentException();
        String number = strNumber.replace(",",".");
        return Double.parseDouble(strNumber);
    }
}
