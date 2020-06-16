class Solution {
    public String validateIPv4(String IP) 
    {
        String[] nums = IP.split("\\.", -1);
    
     for (String num : nums) {

      if (num.length() == 0 || num.length() > 3)      
      {
          return "Neither";
      }
      if (num.charAt(0) == '0' && num.length() != 1)      
      {
          return "Neither";
      }
      for (char ch : num.toCharArray()) 
      {
        if (! Character.isDigit(ch))       
        {
          return "Neither";
        }
      }
      if (Integer.parseInt(num) > 255)
      {
          return "Neither";
      }
    }
    return "IPv4";
  }

  public String validateIPv6(String IP) 
  {
    String[] nums = IP.split(":", -1);
    String hexdigits = "0123456789abcdefABCDEF";
    for (String num: nums) 
    {

      if (num.length() == 0 ||num.length() > 4)
      {
          return "Neither";
      }
      for (Character ch : num.toCharArray()) {
        if (hexdigits.indexOf(ch) == -1)
        {
            return "Neither";
        }
      }
    }
    return "IPv6";
  }

  public String validIPAddress(String IP) {
    if (IP.chars().filter(ch -> ch == '.').count() == 3) {
      return validateIPv4(IP);
    }
    else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
      return validateIPv6(IP);
    }
    else return "Neither";
  } 
    
}