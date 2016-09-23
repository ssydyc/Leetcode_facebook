public class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        ArrayList<String> pathList = new ArrayList<String>();
        
        for(int i = 0; i < paths.length; i++) {
            if (paths[i].equals("")) {
                continue;
            } else if (paths[i].equals(".")) {
                continue;
            } else if (paths[i].equals("..")) {
                if (pathList.size() > 0) {
                    pathList.remove(pathList.size() - 1);
                }
            } else {
                pathList.add(paths[i]);
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < pathList.size(); i++) {
            res.append("/" + pathList.get(i));
        }
        
        if (pathList.size() == 0) {
            return "/";
        } else {
            return res.toString();
        }
        
    }
}
