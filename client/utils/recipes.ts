export const getRecipeSaved = (id: number) => {
  if (localStorage.getItem("savedRecipes") == null) return false;
  else {
    const savedRecipesArr = JSON.parse(localStorage.getItem("savedRecipes"));
    const savedRecipes = new Set(savedRecipesArr);

    return savedRecipes.has(id);
  }
};
