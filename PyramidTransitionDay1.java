// New Observation : Rather than trying to build whole possiblities and then check if they are allowed or not (Bad idea)
// Try to build from allowed.
//Every time only 1 Function can't solve the problem.
class PyramidTransitionDay1 
{
    public void buildNextLevel(String bottom,int index,StringBuilder nextLevel,HashMap<String,List<Character>> map, List<String> result)
    {
        if(index==bottom.length()-1)
        {
            result.add(nextLevel.toString());
            return;
        }
        String s = bottom.substring(index,index+2);
        if(!map.containsKey(s))
        {
            return;
        }
        for(char c : map.get(s))
        {
            nextLevel.append(c);
            buildNextLevel(bottom,index+1,nextLevel,map,result);
            nextLevel.deleteCharAt(nextLevel.length()-1);
        }
    }
    public boolean canBuild(String bottom,HashMap<String,List<Character>> map,HashMap<String,Boolean> memo)
    {
        if(bottom.length()==1)
        {
            return true;
        }
        if(memo.containsKey(bottom))
        {
            return memo.get(bottom);
        }
        List<String> result = new ArrayList<>();
        buildNextLevel(bottom,0,new StringBuilder(),map,result);
      //After checking for the top most only you are saying to mark true
      // This is useful when there is not chance to build using particular next level.
      //It is checking for all the next levels
      // Show micro level functions like for building level one function , for checking other function
        for(String s:result)
        {
            if(canBuild(s,map,memo))
            {
                memo.put(bottom,true);
                return true;
            }
        }
        // If bottom can be build compute for the, try for higher levels.
        memo.put(bottom,false);
        return false;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) 
    {
        //useful to find if possiblity exists for bottom
        HashMap<String,List<Character>> map = new HashMap<>();
        for(String a:allowed)
        {
            String key = a.substring(0,2);
            Character value = a.charAt(2);
            map.computeIfAbsent(key,k-> new ArrayList<>()).add(value);
        }

        //If CE occurs at first and we can't build over it next time if it comes, don't compute directly return false
        HashMap<String,Boolean> memo = new HashMap<>();
        return canBuild(bottom,map,memo);
    }
}
