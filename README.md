- maven copy plugin
- maven open api plugin
- avro template
- spring kafka listener
- spring kafka consumer
- gr - kms config

## Run plugin from IDEA

From inside Gradle toolbar on the right run `runIde` located under `Tasks/intellij

## Live templates

Create a live template in the standard way, then find it under `/home/<USER_NAME>/.config/JetBrains/IntelliJIdea2021.1/templates`.

- [predefined functions](https://www.jetbrains.com/help/idea/template-variables.html?s=quick#predefined_functions)

## Code Snippets

### Access PSI file

- [rules for working with files](https://plugins.jetbrains.com/docs/intellij/documents.html#what-are-the-rules-of-working-with-documents)

- From an Action: `e.getData(CommonDataKeys.PSI_FILE)`.
- From a VirtualFile: `PsiManager.getInstance(project).findFile()`
- From a Document: `PsiDocumentManager.getInstance(project).getPsiFile()`
- From an element inside the file: `PsiElement.getContainingFile()`
- To find files with a specific name anywhere in the project, use `FilenameIndex.getFilesByName(project, name, scope)`

### Iterate over PSI file elements

```java
psiFile.accept(new PsiRecursiveElementWalkingVisitor() {
    // visitor implementation ...
});
```

### Access Caret

```java
public class EditorAreaIllustration extends AnAction {
    @Override
    public void actionPerformed(@NotNull final AnActionEvent e) {
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();
        Caret primaryCaret = caretModel.getPrimaryCaret();
        LogicalPosition logicalPos = primaryCaret.getLogicalPosition();
        VisualPosition visualPos = primaryCaret.getVisualPosition();
        int caretOffset = primaryCaret.getOffset();
    }
}
```

### Insert text 

```java
class MyTypedHandler implements TypedActionHandler {
  @Override
  public void execute(@NotNull Editor editor, char c, @NotNull DataContext dataContext) {
    Document document = editor.getDocument();
    Project project = editor.getProject();
    Runnable runnable = () -> document.insertString(0, "editor_basics\n");
    WriteCommandAction.runWriteCommandAction(project, runnable);
  }
}
```

## Common tasks documentation

- [Register Action](https://plugins.jetbrains.com/docs/intellij/working-with-custom-actions.html#registering-a-custom-action)